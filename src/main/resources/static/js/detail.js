
var mapModalElement=document.querySelector('#map_modal')
var infoSectionElem=document.querySelector('#infoSection')
//모달창 띄우는 함수
function delClassHide(){
    var closeIcon=document.querySelector('.modal_close', '.fas' ,'.fa-times')
    mapModalElement.classList='openModal'
    closeIcon.addEventListener('click',()=>{
        onClassHide()
    })

    var map = new kakao.maps.Map(mapContainer, mapOption);
    searchAddrFromCoords(map.getCenter(), displayCenterInfo);
    var placeLatLng=new kakao.maps.LatLng(dataY,dataX)
    locationPoint(placeLatLng,map)
}

//모달창 숨기기 함수
function onClassHide(){
    mapModalElement.classList='hide'
}

//지도 부분-----------------------------------------------------------------------
var dataX=mapModalElement.dataset.x
var dataY=mapModalElement.dataset.y
var mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(dataY, dataX), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 생성합니다


// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

var marker = new kakao.maps.Marker(), // 클릭한 위치를 표시할 마커입니다
    infowindow = new kakao.maps.InfoWindow({zindex:1}); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다

// 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다


//지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다

function locationPoint(LatLng,map){
    searchDetailAddrFromCoords(LatLng,function (result, status){
        if(status===kakao.maps.services.Status.OK){
            var detailAddr = !!result[0].road_address ? '<div>도로명주소 : ' + result[0].road_address.address_name + '</div>' : '';
            detailAddr += '<div>지번 주소 : ' + result[0].address.address_name + '</div>';

            var content = '<div class="bAddr">' +
                '<span class="title">법정동 주소정보</span>' +
                detailAddr +
                '</div>';

            // 마커를 클릭한 위치에 표시합니다
            marker.setPosition(LatLng);
            marker.setMap(map);

            // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
            infowindow.setContent(content);
            infowindow.open(map, marker);
        }
    })
}
// kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
//     searchDetailAddrFromCoords(mouseEvent.latLng, function(result, status) {
//         if (status === kakao.maps.services.Status.OK) {
//             var detailAddr = !!result[0].road_address ? '<div>도로명주소 : ' + result[0].road_address.address_name + '</div>' : '';
//             detailAddr += '<div>지번 주소 : ' + result[0].address.address_name + '</div>';
//
//             var content = '<div class="bAddr">' +
//                 '<span class="title">법정동 주소정보</span>' +
//                 detailAddr +
//                 '</div>';
//
//             // 마커를 클릭한 위치에 표시합니다
//             marker.setPosition(mouseEvent.latLng);
//             marker.setMap(map);
//
//             // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
//             infowindow.setContent(content);
//             infowindow.open(map, marker);
//         }
//     });
// });

// // 중심 좌표나 확대 수준이 변경됐을 때 지도 중심 좌표에 대한 주소 정보를 표시하도록 이벤트를 등록합니다
// kakao.maps.event.addListener(map, 'idle', function() {
//     searchAddrFromCoords(map.getCenter(), displayCenterInfo);
// });

function searchAddrFromCoords(coords, callback) {
    // 좌표로 행정동 주소 정보를 요청합니다
    geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);
}

function searchDetailAddrFromCoords(coords, callback) {
    // 좌표로 법정동 상세 주소 정보를 요청합니다
    geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
}

// 지도 좌측상단에 지도 중심좌표에 대한 주소정보를 표출하는 함수입니다
function displayCenterInfo(result, status) {
    if (status === kakao.maps.services.Status.OK) {
        var infoDiv = document.getElementById('centerAddr');

        for(var i = 0; i < result.length; i++) {
            // 행정동의 region_type 값은 'H' 이므로
            if (result[i].region_type === 'H') {
                infoDiv.innerHTML = result[i].address_name;
                break;
            }
        }
    }
}


//맵으로 인해
mapModalElement.className='hide'

//------------------------------swiper-------------------------------------------------------
const swiper = new Swiper('.swiper-container', {
    // Optional parameters
    direction: 'horizontal',
    loop: false,

    // If we need pagination
    pagination: {
        el: '.swiper-pagination',
    },

    // Navigation arrows
    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
    },

    // And if we need scrollbar
    scrollbar: {
        el: '.swiper-scrollbar',
    },
});

//---------------------댓글창 부분---------------------------------------------------------------
const formCmt=document.cmtWindow
const CMTCONTAINER=document.querySelector('#cmtContainer')
var iuser=infoSectionElem.dataset.iuser
var iboard=infoSectionElem.dataset.iboard
makeComList()

//댓글 테이블 구현
function makeComList(){
    fetch('/detail/cmtLoad?iboard='+iboard)
        .then(res => res.json())
        .then(myJson => {

            const TABLETAG=document.createElement('table')
            const TRTAG=document.createElement('tr')
            const THTAG1=document.createElement('th')
            const THTAG2=document.createElement('th')
            const THTAG3=document.createElement('th')
            const THTAG4=document.createElement('th')

            THTAG1.innerText='작성자'
            THTAG2.innerText='댓글내용'
            THTAG3.innerText='작성일'
            TRTAG.append(THTAG1)
            TRTAG.append(THTAG2)
            TRTAG.append(THTAG3)
            TRTAG.append(THTAG4)
            TABLETAG.append(TRTAG)

            myJson.forEach(function(currentValue){
                const CMTTR=document.createElement('tr')
                const CMTTD1=document.createElement('td')
                const CMTTD2=document.createElement('td')
                const CMTTD3=document.createElement('td')
                const CMTTD4=document.createElement('td')

                if(iuser==currentValue.iuser){
                    const ICONTAG=document.createElement('i')
                    ICONTAG.classList='far fa-trash-alt pointer'
                    ICONTAG.dataset.icmt=currentValue.icmt
                    ICONTAG.addEventListener('click', delCmt)
                    CMTTD4.append(ICONTAG)
                }

                CMTTD1.innerText=currentValue.writer
                CMTTD2.innerText=currentValue.cmt
                CMTTD3.innerText=currentValue.regdt

                CMTTR.append(CMTTD1)
                CMTTR.append(CMTTD2)
                CMTTR.append(CMTTD3)
                CMTTR.append(CMTTD4)

                TABLETAG.append(CMTTR)
            })

            CMTCONTAINER.append(TABLETAG)
        })
}

//댓글 업로드
function uploadCmt(){
    var cmtData={
        iuser:infoSectionElem.dataset.iuser,
        iboard:infoSectionElem.dataset.iboard,
        cmt:formCmt.cmt.value
    }

    if(cmtData.cmt==''){
        alert('댓글을 입력하세요')
        return false
    }else if(cmtData.cmt.replace(/^\s+|\s+$/g,'')==''){
        alert('댓글창이 공백입니다')
        return false
    }
    fetch('/detail/cmtUpload',{
        method: 'POST',
        headers:{"Content-Type":"application/json; charset=utf-8"},
        body: JSON.stringify(cmtData)
    }).then(res => res.json())
        .then(myJson =>{
            switch(myJson){
                case 0:
                    alert('댓글 입력에 실패')
                    break
                case 1:
                    alert('댓글 입력 성공')
                    location.reload()
                    break
            }
        })
    return false
}

//댓글 수정
function modCmt(){

}

//댓글 삭제
function delCmt(){
    if(confirm('댓글을 삭제하시겠습니까?')){
        icmt=this.dataset.icmt
        fetch('/detail/cmtDel',{
            method: 'POST',
            headers:{'Content-Type':'application/json; charset=utf-8'},
            body: JSON.stringify({icmt:icmt, iuser:iuser})
        }).then(res => res.json())
            .then(myJson =>{
                switch (myJson) {
                    case 1:
                        alert('삭제되었습니다')
                        location.reload()
                        break
                    case 0:
                        alert('삭제실패')
                        break
                }
            })
    }
}

//좋아요 부분
var iconFavElem=document.querySelector('#thumbs-up')
const ICONFAV=document.createElement('i')
if(iconFavElem.dataset.myfav==0){
    ICONFAV.classList='far fa-thumbs-up pointer'
    ICONFAV.addEventListener('click',insFav)
}else{
    ICONFAV.classList='fas fa-thumbs-up pointer'
    ICONFAV.addEventListener('click',delFav)
}
ICONFAV.innerText=iconFavElem.dataset.favcount
iconFavElem.append(ICONFAV)

function insFav(){
    fetch('/detail/insFav',{
        method:'POST',
        headers:{'Content-Type':'application/json; charset=utf-8'},
        body:JSON.stringify({iuser:1, iboard:iboard})
    }).then(res => res.json())
        .then(myJson => {
            if(myJson==1){
                ICONFAV.classList='fas fa-thumbs-up pointer'
                iconFavElem.dataset.favcount=parseInt((iconFavElem.dataset.favcount))+1
                ICONFAV.innerText=iconFavElem.dataset.favcount
                ICONFAV.removeEventListener('click',insFav)
                ICONFAV.addEventListener('click',delFav)
            }
        })
}

function delFav(){
    fetch('/detail/delFav',{
        method:'POST',
        headers:{'Content-Type':'application/json; charset=utf-8'},
        body:JSON.stringify({iuser:1, iboard:iboard})
    }).then(res => res.json())
        .then(myJson => {
            if(myJson==1){
                ICONFAV.classList='far fa-thumbs-up pointer'
                iconFavElem.dataset.favcount=parseInt((iconFavElem.dataset.favcount))-1
                ICONFAV.innerText=iconFavElem.dataset.favcount
                ICONFAV.removeEventListener('click',delFav)
                ICONFAV.addEventListener('click',insFav)
            }
        })
}


//<i className="fas fa-thumbs-up"></i> 채워진거
//<i className="far fa-thumbs-up"></i>    안채워진거