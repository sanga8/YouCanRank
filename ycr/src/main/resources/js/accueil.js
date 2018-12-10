


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