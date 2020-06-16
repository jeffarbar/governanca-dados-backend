# governanca-dados-backend

#Documentação elasticsearch
https://www.elastic.co/guide/en/elasticsearch/reference/7.x/index.html

#Conceitos do elasticsearch
https://tasafo.wordpress.com/2014/08/09/iniciando-com-elasticsearch/

#Quarys
https://docs.spring.io/spring-data/elasticsearch/docs/1.0.0.M1/reference/html/elasticsearch.repositories.html

docker network create somenetwork
docker run -d --name elasticsearch --net somenetwork -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" elasticsearch:7.7.0

vim /etc/hosts
127.0.0.1       elasticsearch


#Criação do index
curl -X PUT "elasticsearch:9200/governanca?pretty" -H 'Content-Type: application/json' -d'
{
    "settings" : {
        "index" : {
            "number_of_shards" : 1, 
            "number_of_replicas" : 1 
        }
    }
}
'



curl -X POST "elasticsearch:9200/governanca/catalogodados" -H 'Content-Type: application/json' -d' {"bancoDado":"RH","tabela":"FUNCIONARIO","nome":"Dicionário de Dados - Monetizacao","definicao":"Data do fim da sessao. E a data em que a sessao foi encerrada. Ex: 43678,9409722222; 43678,0486111111.","dominioNegocio":"ENGENHARIA REDE","assunto":"CLARO WIFI","dominioDados":"Banda Larga","subDominioDados":"Conexao"} '



curl -X GET "elasticsearch:9200/governanca/catalogodados/_search?pretty"


#Executar 
docker run --name catalogo-dados-backend --link elasticsearch  --network somenetwork  -p 8092:8092 -d jeffersonfarias/catalogo-dados-backend:1.0.0
