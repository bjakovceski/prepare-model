# import bs4
# import requests
#
# filepath = 'C:/Users/Jakovcheski/Desktop/clean-big-nif-page-structure_en-linksA.ttl'
# file = open('C:/Users/Jakovcheski/Desktop/testfile.txt','w', encoding="utf8")
# with open(filepath, encoding="utf8") as fp:
#     line = fp.readline()
#     while line:
#         res = requests.get(line)
#         soup = bs4.BeautifulSoup(res.text, 'lxml')
#         person = soup.find('a', href="http://dbpedia.org/ontology/Person")
#         label = soup.find('span', property="rdfs:label")
#         if person is not None:
#             if label is not None:
#                 print(label.text + '\t' + (person.text).upper()[:3] )
#                 oneWordLabel = label.text.split()
#                 for temp in oneWordLabel:
#                     file.write(temp + '\t' + (person.text).upper()[:3]+ '\n')
#         print(line.strip())
#         line = fp.readline()
#         print('next line ' + line)
#     file.close()

import bs4
import asyncio
from aiohttp import ClientSession

async def fetch(url, session):
    async with session.get(url) as response:
        print("{}".format(url))
        return await response.read()

async def bound_fetch(sem, url, session):
    async with sem:
        await fetch(url, session)

def parseAndStorePersonToken(response, outputFile):
    soup = bs4.BeautifulSoup(response, 'lxml')
    person = soup.find('a', href="http://dbpedia.org/ontology/Person")
    if person is not None:
        label = soup.find('span', property="rdfs:label")
        if label is not None:
            oneWordLabel = label.text.split()
            for temp in oneWordLabel:
                outputFile.write(temp + '\t' + (person.text).upper()[:3] + '\n')

async def run():

    inputFile = 'C:/Users/Jakovcheski/Desktop/clean-big-nif-page-structure_en-linksA.ttl'
    outputFile = 'C:/Users/Jakovcheski/Desktop/personTokensA.txt'

    tasks = []
    sem = asyncio.Semaphore(1000)

    async with ClientSession() as session:
        with open(inputFile, encoding='utf8') as urls:
            for url in urls:
                task = asyncio.ensure_future(bound_fetch(sem, url, session))
                tasks.append(task)

        with open(outputFile, 'a') as ofile:
            for response in await asyncio.gather(*tasks):
                # if response:
                parseAndStorePersonToken(response, ofile)

loop = asyncio.get_event_loop()
future = asyncio.ensure_future(run())
loop.run_until_complete(future)
