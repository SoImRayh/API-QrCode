# QrCode Api
## Api Rest feita para a geração de QR codes


### como iniciar
Caso possua docker instalado na sua máquina apenas execute o comando
```shell
docker build -t qr_api . && docker run -p 8080:8080 qr_api
```

Logo após a aplicação estar pronta utilize algum cliente http para fazer uma requisição post no endereço

``
http://localhost:8080/api/v1/qrcode?width=200
``

Contendo no corpo da requisição um JSON no seguinte formato chave/valor:

````JSON
{
  "text": "https://rayh.dev" /* alterar o texto anterior para o de sua vontade */
}
````

### Personalizações
Atualmente o unico parâmetro aceito é a dimensão do QRcode que é dada no caminho (link) com o nome width
voce alterar a resolução nos valores de 200 á 1080, com o valor padrão sendo 200;