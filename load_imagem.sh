docker build -t jeffersonfarias/catalogo-dados-backend:1.0.0  -f Dockerfile .
docker login --username=jeffersonfarias
docker push jeffersonfarias/catalogo-dados-backend:1.0.0
