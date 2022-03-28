var Links = {
  setColor:function (color){
    // var links = document.querySelectorAll('a');
    // var i = 0;
    // while(i<links.length){
    //   links[i].style.color = color;
    //   i = i + 1;
    // }
    //jquery -> $, jquery 사용시 위의 주석 처리된 반복문을 직접 작성하지 않아도 됨
    $('a').css('color', color);  //여기 있는 모든 a 태그를 jQuery로 해결하겠다는 뜻 -> a태그의 css를 바꾼다는 코드
  }
}
  var BodyColor = {
    setFontColor:function (FColor){
        //document.querySelector('body').style.color = FColor;
        $('body').css('color', FColor);
      },
    setBackground:function (BColor){
          //document.querySelector('body').style.backgroundColor = BColor;
          $('body').css('backgroundColor', BColor);
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
