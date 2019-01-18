<html>
        <head>
          <title>JSON Custom Search API Example</title>
        </head>
        <body>
          <input id="search" type="text" />
          <input onclick="myFunction();" type="submit"/>
          <div id="content"></div>
          <script>



var url = 'https://www.googleapis.com/customsearch/v1?num=1&key=840e9f0882d34a53b691f571b6371de5';
       

var req = new Request(url);

fetch(req)
    .then(function(response) {
        console.log(response.json());
    })



          </script>
          <style>

          </style>
        </body>
      </html>
<!--https://https://newsapi.org/v2/top-headlines?country=fr&apiKey=840e9f0882d34a53b691f571b6371de5-->