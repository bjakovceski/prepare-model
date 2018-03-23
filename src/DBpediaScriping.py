import bs4
import requests

res = requests.get('http://dbpedia.org/page/Allan_Dwan?dbpv=2016-04&nif=section_0_136')
type(res)

soup = bs4.BeautifulSoup(res.text, 'lxml')

person = soup.find('a', href="http://dbpedia.org/ontology/Person")
label = soup.find('span', property="rdfs:label")

print(label.text + '\t' + (person.text).upper()[:3])