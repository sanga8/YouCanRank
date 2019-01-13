$(document).ready(function() {
      
  $('#topSearch').autocomplete({
    serviceUrl: '/getTop',
    paramName: "titre",
    delimiter: ",",
     transformResult: function(response) {
          
    return {      	
      //must convert json to javascript object before process
      suggestions: $.map($.parseJSON(response), function(item) {
          
          return { value: item.titre, data: item.id };
       })
                
     };
            
            }
        
   });
        
  });


  function myFunction() {
    
    if (document.getElementById('corps').getAttribute('class') == "no" )
    {
      document.getElementById('corps').className = "yes";
      document.getElementById('corps').style.backgroundColor = "rgba(0,0,0,0.4)";
      document.getElementById("corps").style.marginLeft = "300px";
      document.getElementById("Sidenav").style.width = "300px";
      document.getElementById("bars").classList.toggle("change");
    }
    else
    {
      document.getElementById('corps').className = "no";
      document.getElementById('corps').style.backgroundColor = "";
      document.getElementById("corps").style.marginLeft = "0";
      document.getElementById("Sidenav").style.width = "0";
      document.getElementById("bars").classList.toggle("change");
    }
}

function hideShow(i) {
  var x = document.getElementById("q"+i);
  i=i-1
  var y = document.getElementById("q"+i);
  console.log(y);
  if (x.style.display === "none") {
    x.style.display = "block";
    y.getElementsByTagName('button')[1].textContent="Delete -";
  }
  else  {
    x.getElementsByTagName('input')[0].value="";
    x.getElementsByTagName('input')[1].value=""
    x.style.display = "none";
    y.getElementsByTagName('button')[1].textContent="Add +";
  }
  
}

function result(){
  var x = document.getElementById("topSearch");
  window.location.href = "/search/"+x.value;
}