var Links = {
  setColor:function (color){
    var links = document.querySelectorAll('a');
    var i = 0;
    while(i<links.length){
      links[i].style.color = color;
      i = i + 1;
    }
  }
}
  var BodyColor = {
    setFontColor:function (FColor){
        document.querySelector('body').style.color = FColor;
      },
    setBackground:function (BColor){
          document.querySelector('body').style.backgroundColor = BColor;
        }
  }

  function NightDayHandler(x){
    var target = document.querySelector('body');
    if(x.value === 'Day'){
      BodyColor.setBackground('white');
      BodyColor.setFontColor('black');
      x.value = 'Night';
      Links.setColor('blue');
    }
    else{
      BodyColor.setBackground('black');
      BodyColor.setFontColor('white');
      x.value = 'Day';
      Links.setColor('powderblue');
      }
    }
