const backToTop = document.getElementById('backtotop');

const checkScroll = () => {
    /*
        웹페이지가 수직으로 얼마나 스크롤 되었는지를 확인하는 값(픽셀 단위로 반환)
        https://developer.mozilla.org/ko/docs/Web/API/Window/pageYOffset
    */
    let pageYoffset = window.pageYOffset;
    if (pageYoffset !== 0) {
        backToTop.classList.add('show');
    } else {
        backToTop.classList.remove('show')
    }
}
const moveBackToTop = () => {
    if (window.pageYOffset > 0) {
        /*
            smooth하게 스크롤 하기
            https://developer.mozilla.org/ko/docs/Web/API/Window/scrollTo
        */
        window.scrollTo({
            top: 0,
            behavior: 'smooth'
        });
    }
}

window.addEventListener('scroll', checkScroll);
//스크롤을 할 때 마다 checkScroll 함수를 불러오라는 뜻, window에 event를 걸었기 때문에 어디서 스크롤을 해도 효과가 적용됨
//widnw.aaa -> BOM
backToTop.addEventListener('click', moveBackToTop);

/*---------------------------------------------------------------------------------------*/
function transformNext(event) {
    const slideNext = event.target;
    const slidePrev = slideNext.previousElementSibling;
    const classList = slideNext.parentElement.parentElement.nextElementSibling;
    let activeLi = classList.getAttribute('data-position');
    const liList = classList.getElementsByTagName('li');

    //하나의 카드라도 왼쪽으로 이동했다면, 오른쪽으로 갈 수 있음
    if (Number(activeLi) < 0) {
        activeLi = Number(activeLi) + 260;
        if (Number(activeLi) >= 0) {
            slideNext.style.color = "#cfd8dc";
            slideNext.classList.remove('slide-next-hover');
            slideNext.removeEventListener('click', transformNext);
        }

        slidePrev.style.color = 'rgb(47, 48, 89)';
        slidePrev.classList.add('slide-prev-hover'); //prev 버튼 활성화
        slidePrev.addEventListener('click', transformPrev);
    }

    classList.style.transition = "transform  1s";
    classList.style.transform = "translateX(" + String(activeLi) + "px)";
    classList.setAttribute('data-position', activeLi);
}

//hostingIssue를 방지하기 위해 function 생성(arrow function 사용 X)
function transformPrev(event) {
    //해당 이벤트가 발생한 요소의 정보등을 알기 위해 event element 추가
    const slidePrev = event.target;
    //console.log(slidePrev); //<i class="slide-prev fas fa-chevron-circle-left slide-prev-hover" aria-hidden="true"></i>가 출력
    const slideNext = slidePrev.nextElementSibling;
    //console.log(slideNext); //<i class="slide-prev fas fa-chevron-circle-right slide-next-hover" aria-hidden="true"></i>가 출력

    //관련된 ul tag 선택
    const classList = slidePrev.parentElement.parentElement.nextElementSibling;
    let activeLi = classList.getAttribute('data-position'); //해당 태그의 속성에 대한 값을 가져오는 함수
    //class-list 부분의 data-position
    const liList = classList.getElementsByTagName('li');

    /* classList.clientWidth 는 ul 태그의 실질적인 너비
     * liList.length * 260 에서 260dms 각 li 요소의 실질 너비(margin 포함) 
     * activeLi 는 data-position에 있는 현재 위치
     * 즉, liList.length * 260 + Number(activeLi) 는 현재 위치부터 오른쪽으로 나열돼야 하는 나머지 카드들의 너비
    */
    /* classList.clientWidth < (liList.length * 260 + Number(actvieLi)) 의미는
     * 오른쪽으로 나열될 카드들이 넘친 상태이므로, 왼쪽으로 이동이 가능함
    */
    if (classList.clientWidth < (liList.length * 260) + Number(activeLi)) { //왼쪽으로 이동할 수 있는 상태인지 확인
        activeLi = Number(activeLi) - 260; //왼쪽으로 position 값만 이동
        /* 위치를 왼쪽으로 260 이동 (-260px)
         * 해당 위치는 변경된 activeLi 값이 적용된 liList.length * 260 + Number(activeLi) 값임
         * 이 값보다, classList.clientWidth(ul tag의 너비)가 크다는 것은 
         * 넘치는 li가 없다는 뜻으로 NEXT 버튼은 활성화 되면 안됨
        */

        if (classList.clientWidth > (liList.length * 260) + Number(activeLi)) { //왼쪽으로 옮기고 난 후 class-card가 classList.clientWidth보다 작은 경우
            slidePrev.style.color = "#cfd8dc";
            slidePrev.classList.remove('slide-prev-hover');
            slidePrev.removeEventListener('click', transformPrev);
        }
        slideNext.style.color = 'rgb(47, 48, 89)';
        slideNext.classList.add('slide-next-hover');
        slideNext.addEventListener('click', transformNext);
    }

    classList.style.transition = "transform  1s";
    classList.style.transform = "translateX(" + String(activeLi) + "px)";
    classList.setAttribute('data-position', activeLi); // 이동 후 data-position 값 다시 저장
    //overflow를 hidden으로 설정하면 transform 시 이미지 짤림
}
const slidePrevList = document.getElementsByClassName('slide-prev'); //getElementsByClassName -> 해당하는 것을 list로 반환

for (let i = 0; i < slidePrevList.length; i++) {
    //ul tag 선택
    let classList = slidePrevList[i].parentElement.parentElement.nextElementSibling;
    let liList = classList.getElementsByTagName('li'); /* class-list에 class-card 각각을 담은 object가 반환 됨 */
    //console.log(liList);
    //카드가 ul 태그 너비보다 넘치면, 왼쪽(prev) 버튼을 활성화 하고, 오른쪽(next)는 현재 맨 첫카드 위치이므로 비활성화(tag 삭제)
    //ul tag 안에서 각 카드가 차지하는 실제 width를 가져오는 방법: clientWidth property 사용
    //console.log(classList.clientWidth); //전체 화면 (패딩, 마진 등 포함): 1200px(max) , classList의 clientWidth: 1136px
    if (classList.clientWidth < (liList.length * 260)) { //class-card 하나의 width=240px, 양쪽 margin = 10px => total 260 px
        slidePrevList[i].classList.add('slide-prev-hover');
        slidePrevList[i].addEventListener('click', transformPrev);
    } else {
        /* 
            태그 삭제시, 부모 요소에서 removeChild를 통해 삭제해야 함
            따라서, 1. 먼저 부모요소를 찾아서
                  2. 부모 요소의 자식 요소로 있는 PREV, NEXT 요소를 삭제함        
        */
        const arrowContainer = slidePrevList[i].parentElement;
        arrowContainer.removeChild(slidePrevList[i].nextElementSibling);
        arrowContainer.removeChild(slidePrevList[i]); //< > 버튼 삭제
    }
}