a = 'youcanrankapi';

function searchImage(id){
    a = id
    if(a===search){
      var x =id.value;
     }
     else{
      var x =id.getElementsByTagName('input')[0].value;
     }
    
    console.log(x);
    script = document.createElement('script'),
    head = document.getElementsByTagName('head')[0]
    script.src = "https://www.googleapis.com/customsearch/v1?num=1&key=AIzaSyB8n4ZGjzmdXhbvIaUCPtHf2_IalryZRi8&cx=009122468185306112560:ke7sd2bstaw&searchType=image&fileType=jpg&imgSize=medium&callback=hndlr&q="+x;
    head.appendChild(script);

  }

function hndlr(response) {
   for (var i = 0; i < response.items.length; i++) {
     var item = response.items[i];
     // in production code, item.htmlTitle should have the HTML entities escaped.
     if(a===search){
      document.getElementById("image").value=item.link;
     }
     else{
      a.getElementsByTagName('input')[1].value=item.link;
     }
     document.body.style.backgroundImage = "url('"+item.link+"')";
     script.parentNode.removeChild( script );
   }
 }