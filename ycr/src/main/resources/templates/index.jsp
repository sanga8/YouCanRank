<!DOCTYPE html>
<html>

  <head>
    <meta charset="utf-8">
    <title>YouCanRank</title>
    <link rel="icon" type="image/png" href="icon.png" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/accueil.css" />
    <script src="../js/accueil.js"></script>
  </head>

  <body>
        <header>
          <nav class="navbar navbar-dark sticky-top">
              <div class="menu col-sm-1" onclick="myFunction()" id="bars">
                <div class="bar1"></div>
                <div class="bar2"></div>
                <div class="bar3"></div>
              </div>
              <div class="logo col-sm-2"><a href="index.html"><img src="../images/logoblanc.png" height="35px"></a></div>
                <div class="search-container col-sm-7">
                  <form id="search-bar" action="#">
                    <input type="text" placeholder="Search.." name="search">
                    <button type="submit"><i class="fa fa-search"></i></button>
                  </form>
                </div>
                <div class="create col-sm-1">
                  <button type="submit">CREATE</button>
                </div>
                <div class="user col-sm-1">
                  <button type="submit"><i class="far fa-user"></i></button>
                </div>
            </nav>
        </header>

        <div id="Sidenav" class="sidenav">
          <a href="javascript:void(0)" class="closebtn" onclick="myFunction()">&times;</a>
          <a href="#">About</a>
          <a href="#">Services</a>
          <a href="#">Clients</a>
          <a href="#">Contact</a>
        </div>

        <div id="corps" class="no">

        </div>

        <footer>

        </footer>

  </body>
</html>