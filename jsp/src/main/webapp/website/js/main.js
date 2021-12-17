/* 다음주소 api*/
  //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
			
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
    }
/*다음주소 api end*/
/*결제방식체크 start*/
function payselect(pay){
	document.getElementById("pay").innerHTML = pay;
}

/*결제방식체크 end*/
/*결제*/
function payment(){
	if(document.getElementById("pay").innerHTML==""){
		alert("결제방식을 먼저 선택해주세요"); return;
	}
	var IMP = window.IMP; // 생략 가능
    IMP.init("imp96520987"); // 예: imp00000000
     // IMP.request_pay(param, callback) 결제창 호출
      IMP.request_pay({ // param
          pg: "html5_inicis",									// 결제 사
          pay_method: document.getElementById("pay").innerHTML,	// 결제 방식
          merchant_uid: "ORD20180131-0000011",	//
          name: "BMW ONLINE SHOP",
          amount: document.getElementById("totalpay").innerHTML,
          buyer_email: "gildong@gmail.com",
          buyer_name: $("#mname").val(),
          buyer_tel: $("#mphone").val(),
          buyer_addr: $("#sample4_postcode").val()+","+$("#sample4_roadAddress").val()+","+$("#sample4_jibunAddress").val(),
          buyer_postcode: $("#sample4_postcode").val()
      }, function (rsp) { // callback
          if(rsp.success) {
	
          }else{// 결제 실패했을시
          		// 테스트 : 결제 성공이라고 생각
          		$.ajax({
					url : "/jsp/website/controller/productpaymentcontroller.jsp",
					data : { 
						order_name : $("#mname").val(),
						order_phone : $("#mphone").val(),
						order_address : $("#sample4_postcode").val()+","+$("#sample4_roadAddress").val()+","+$("#sample4_jibunAddress").val()+$("#sample4_postcode").val(),
						order_pay : document.getElementById("totalpay").innerHTML,
						order_payment : document.getElementById("pay").innerHTML,
						delivery_pay : 220000,
						order_contents : document.getElementById("order_contents").value
					},
					success : function(result){
						if(result==1){
						alert("주문이 완료되었습니다.");
							// 결제완료 페이지						
							location.href="productpaymentsuccess.jsp";
						}else{
							alert("DB오류야멍충멍충");
						}
					}
				});
          }
      });
}



/* 아이디 중복체크 [ ajax ] */
	$( function(){
		// $("id명").이벤트명( 함수명(){ 실행코드; } );
		$("#id").change( function() { 
			// 비동기식 : $.ajax({ 속성명 : "값" , 속성명 : "값" , 속석명 : "값" });
			$.ajax({ 
				url : "idcheck.jsp" ,	
				/* url : 통신할 경로 페이지 */ 
				data :{userid:document.getElementById("signupform").id.value} , 	
				/* 이동할 데이터 */
				success : function( result ){ 
				/* 통신이 성공했을때*/
					if( result == 1 ){ 	// js 변수는 자료형 없다
						document.getElementById("idresult").innerHTML = "사용중인 아이디";
					}else{
						
					}
				}
			});
		});
	});
/* 아이디 중복체크 end */

/* 회원탈퇴 [ajax :jquery가있어야함] */
	$(function(){
		// $(function(){실행문}); : 함수
		$("#delete").click(function(){
			// ajax : 비동기식 통신 [ 페이지 전환없이 통신 가능 ]
			/*$.ajax({속성명 : "값",속성명:"값2"})*/
			$.ajax({
				url : "../../controller/memberdeletecontroller.jsp" ,
				/*url : 통신할 경로 페이지*/
				data : {password:document.getElementById("deleteform").password.value},
				// data : 
				success : function(result) {
					// 통신 성공시 
					if(result == 1) { // js 변수는 자료형 없다
					// 통신 성공후 반환값 확인
						alert('회원탈퇴 되었습니다.');
						location.href='../view/main.jsp'; 
					}else{
						document.getElementById("deleteresult").innerHTML = "패스워드가 일치하지않습니다.";
						document.getElementById("deleteresult").style.color = "red";
					}
				}
			});
		}); // 버튼 클릭했을때 함수 끝
	});	// 전체 함수 끝
/*회원탈퇴 end*/
/*회원 이름 수정*/
function namechange(){
	alert("이름수정후 확인버튼을 눌러주세요.");
	document.getElementById("tdname").innerHTML = "<input type='text' id='name' class='form-control' > <br> <button id='namechangebtn' class='btn btn-warning'>확인</button>";
	$(function(){
		$("#namechangebtn").click(function(){
			$.ajax({
				url : "../../controller/memberinfoupdatecontroller.jsp",
				data : {name:document.getElementById("name").value},
				success : function(result) {
					if(result == 1) {
						alert('회원님의 이름이 수정되었습니다.');
						location.href='memberinfo.jsp';
					}else{
						alert('이름수정실패');
						location.href='memberinfo.jsp';
					}
				}
			});
		});		
	});
}
/*회원이름 수정end*/
/*회원 비밀번호 수정*/
function passwordchange(){
	alert("비밀번호 수정후 확인버튼을 눌러주세요.");
	document.getElementById("tdpassword").innerHTML = "<input type='password' id='password' class='form-control' > <br> <button id='passwordchangebtn' class='btn btn-danger'>확인</button>";
	$(function(){
		$("#passwordchangebtn").click(function(){
			$.ajax({
				url : "../../controller/memberinfoupdatecontroller.jsp",
				data : {password:document.getElementById("password").value},
				success : function(result) {
					if(result == 1) {
						alert('회원님의 비밀번호가 수정되었습니다.');
						location.href='memberinfo.jsp';
					}else{
						alert('비밀번호수정실패');
						location.href='memberinfo.jsp';
					}
				}
			});
		});		
	});
}
/*회원 비밀번호 수정end*/	
/*회원 성별 수정*/
function sexchange(){
	alert("성별 수정후 확인버튼을 눌러주세요.");
	document.getElementById("tdsex").innerHTML = "<input type='radio' name='sex' value='man' id='sex1'>남성<input type='radio' name='sex' value='woman' id='sex2'>여성<br> <button id='sexchangebtn' class='btn btn-primary'>확인</button>";
	$(function(){
		$("#sexchangebtn").click(function(){
			$.ajax({
				url : "../../controller/memberinfoupdatecontroller.jsp",
				data : {sex:document.querySelector('input[name="sex"]:checked').value},
				success : function(result) {
					if(result == 1) {
						alert('회원님의 성별이 수정되었습니다.');
						location.href='memberinfo.jsp';
					}else{
						alert('성별수정실패');
						location.href='memberinfo.jsp';
					}
				}
			});
		});		
	});
}
/*회원 성별 수정end*/	
/*회원 생년월일 수정*/
function birthchange(){
	alert("생일 수정후 확인버튼을 눌러주세요.");
	document.getElementById("tdbirth").innerHTML = "<input type='date' id='birth' class='form-control' > <br> <button id='birthchangebtn' class='btn btn-secondary'>확인</button>";
	$(function(){
		$("#birthchangebtn").click(function(){
			$.ajax({
				url : "../../controller/memberinfoupdatecontroller.jsp",
				data : {birth:document.getElementById("birth").value},
				success : function(result) {
					if(result == 1) {
						alert('회원님의 생일이 수정되었습니다.');
						location.href='memberinfo.jsp';
					}else{
						alert('성별수정실패');
						location.href='memberinfo.jsp';
					}
				}
			});
		});		
	});
}
/*회원 생년월일 수정end*/	
/*회원 연락처 수정*/
function phonechange(){
	alert("번호 수정후 확인버튼을 눌러주세요.");
	document.getElementById("tdphone").innerHTML = "<input type='text' id='phone' class='form-control' > <br> <button id='phonechangebtn' class='btn btn-info'>확인</button>";
	$(function(){
		$("#phonechangebtn").click(function(){
			$.ajax({
				url : "../../controller/memberinfoupdatecontroller.jsp",
				data : {phone:document.getElementById("phone").value},
				success : function(result) {
					if(result == 1) {
						alert('회원님의 전화번호가 수정되었습니다.');
						location.href='memberinfo.jsp';
					}else{
						alert('연락처수정실패');
						location.href='memberinfo.jsp';
					}
				}
			});
		});		
	});
}
/*회원 연락처 수정end*/	

/*회원 주소 수정*/
function addresschange(){
	alert("주소 수정후 확인버튼을 눌러주세요.");
	document.getElementById("tdaddress").style.display="";
	
}
$(function(){
	$("#addersschange").click(function(){
		$.ajax({
			url : "../../controller/memberinfoupdatecontroller.jsp",
			data : {address1:document.getElementById("sample4_postcode").value,
					address2:document.getElementById("sample4_roadAddress").value,
					address3:document.getElementById("sample4_jibunAddress").value,
					address4:document.getElementById("sample4_detailAddress").value
			},
			success : function(result) {
				if(result == 1) {
					alert('회원님의 주소가 수정되었습니다.');
					location.href='memberinfo.jsp';
				}else{
					alert('주소수정실패');
					location.href='memberinfo.jsp';
				}
			}
		})
	});		
});
/*회원 주소 수정end*/	
/*게시물 상태 변경 start*/
function activechange(p_num){
	if( confirm("제품의 상태를 변경하시겠습니까?")== true){
		$(function(){
			$.ajax({
				url : "../../controller/productactivecontroller.jsp",
				data :{p_num:p_num},
				success : function(result){
					if(result==1){
						alert('제품상태가 변경되었습니다.');
						location.reload();
					}else{
						alert('상태변경 실패입니다.');
						location.reload();
					}
				}
			})
		});
	}else{
		
	}
}
/*게시물 상태 변경 end*/
/*제품 수량 변경 start*/
function pchange( type , stock , price) {  // JS는 자료형 X
	var pcount = document.getElementById("p_count").value*1; 
	if(type == 'm') { // 마이너스 버튼을 눌렀을때
		pcount -= 1;
		if(pcount < 1) {
			alert('최소 수량은 1개 입니다.');
			pcount = 1;
		}
	}else if (type== 'p') {
		pcount += 1;
		if(pcount> stock) {
			alert('최대수량입니다.');
			pcount = stock;
		}
	}else {
		pcount += 0;
		if(pcount> stock) {
			alert('죄송합니다. 재고가 부족합니다.');
			pcount = stock;
		}if(pcount < 1) {
			alert('최소 수량은 1개 입니다.');
			pcount = 1;
		}
		return;
	}
	// 현재 수량 입력상자에 대입
	document.getElementById("p_count").value = pcount;
	var totalprice = pcount*price;
	document.getElementById("total").innerHTML = totalprice.toString().replace(/\B(?=(\d{3})+(?!\d))/g,",")+"원";
					// 총가격.toString() : 문자열 변환
						// .replace(기존문자, 새로운문자);
							// 정규표현식 [문자패턴찾기]: /\B(?=(\d{3})+(?!\d))/g
								// 1. / : 시작
								// 2. \b : 시작 , 끝문자 [ 예 : 1234일경우 1, 4 ]
								// 3. \d{3} : 숫자길이 [ 예 {3} : 3글자 ] d= 정수
								// 4. !\d : 뒤에 숫자가 없을 경우 
								// 4. /g : 전역 검색
								 
}	
/*제품 수량 변경 end*/
/*찜하기*/
function plike(p_num,m_num){
	if(m_num==0){alert('로그인후 찜하기가 가능합니다.'); return;}
	// 비동기식 통신
	$(function(){
		$.ajax({
			url : "../../controller/productlickcontroller.jsp",
			data : {p_num : p_num , m_num : m_num},
			success : function(result){
				if(result==1){
					document.getElementById("btnplick").innerHTML = "찜하기♡";
				}else{
					document.getElementById("btnplick").innerHTML = "찜하기♥";
				}
			}
		});
	});
}
/*찜하기 end*/

/* 장바구니 start */
function cartadd(){
	// 제이쿼리를 이용한 값 가져오기 api
		// id 속성 이용
		// var p_num2 = $("#p_num").val();
		// class속성 이용
		// var p_num3 = $(".p_num").val();
		// name 속성 이용
		// var p_num4 = $("input[name=p_num]").val();
	// 자바 스크립트를 이용한 값 가져오기
		// 1. id 속성 이용
		var p_num = document.getElementById("p_num").value;
		// 2. class 속성 이용 class 속성 중복 허용하기 때문에 배열 이용
		// var p_num5 = document.getElementsByClassName("p_num")[0].value;
		// 3. name 속성 이용 name 속성 중복 허용하기 때문에 배열 이용
		// var p_num6 = document.getElementsByName("p_num")[0].value;
		var p_type = document.getElementById("p_type").value;
		if(p_type=="0") {
			alert("옵션을 선택해주세요.");
		}
		var p_count =document.getElementById("p_count").value;
		// 컨트롤러 페이지 이동 [ 1. 하이퍼 링크 2. ajax]
		// location.href = "../../controller/productcartcontroller.jsp?p_num="+p_num+"&p_size+"p_size+"&p_count="p_count;
		$.ajax({ //페이지 전환이 없음 [해당 페이지와 통신]
			url : "../../controller/productcartcontroller.jsp",
			data : {p_num : p_num , p_type : p_type , p_count : p_count},
			success : function(result){
				if(confirm("장바구니에 담았습니다 [ 장바구니로 이동하시겠습니까? ]")==true){
					location.href="productcart.jsp"
				}
			}
		});
}



/* 장바구니 end */

/*장바구니 전체삭제 start*/
function cartdelete(type,p_num,p_type) {
	$.ajax({
		url : "../../controller/productcartdeletecontroller.jsp",
		data : {type : type , p_num : p_num , p_type : p_type},
		success : function(result) {
			location.reload();
		}
	});
}



/*장바구니 전체삭제 end*/

/*장바구니 수량 start*/
function pchange2(i,type,stock,price) {
	var p_count = document.getElementById("p_count"+i).value*1;
	if(type == 'm') { // 마이너스 버튼을 눌렀을때
		p_count -= 1;
		if(p_count < 1) {
			alert('최소 수량은 1개 입니다.');
			p_count = 1;
		}
	}else if (type== 'p') {
		p_count += 1;
		if(p_count> stock) {
			alert('최대수량입니다.');
			p_count = stock;
		}
	}else {
		p_count += 0;
		if(p_count> stock) {
			alert('죄송합니다. 재고가 부족합니다.');
			p_count = stock;
		}if(p_count < 1) {
			alert('최소 수량은 1개 입니다.');
			p_count = 1;
		}
	}
	// 현재 수량 입력상자에 대입
	document.getElementById("p_count"+i).value = p_count;
	var totalprice = p_count*price;
	document.getElementById("total"+i).innerHTML = totalprice.toString().replace(/\B(?=(\d{3})+(?!\d))/g,",")+"원";
	$.ajax({
		url : "../../controller/productcartdeletecontroller.jsp",
		data : {type : type , p_num : -1 , p_type : -1 , i:i , p_count : p_count},
		success : function(result) {
			location.reload();
		}
	});
}
/*장바구니 수량 end*/

/*회원과 동일 체크 start*/
	// 체크 유무 검사 
	// $(document).ready(function(){실행문}); // 문서 대기 메소드
	$(document).ready(function(){
		$("#checkbox").change(function(){
			// 체크박스가 변경되면 = true;
				// .is : 해당태그에 속성 체크 확인
			if($("#checkbox").is(":checked")){ // 체크되면
				$("#mname").val($("#name").val());
				$("#mphone").val($("#phone").val());
				$("#sample4_postcode").val($("#address1").val());
				$("#sample4_roadAddress").val($("#address2").val());
				$("#sample4_jibunAddress").val($("#address3").val());
				$("#sample4_detailAddress").val($("#address4").val());
				
			}else{ // 체크가 해제되면
				$("#mname").val("");
				$("#mphone").val("");
				$("#sample4_postcode").val("");
				$("#sample4_roadAddress").val("");
				$("#sample4_jibunAddress").val("");
				$("#sample4_detailAddress").val("");
			}
		});
	});
/*회원과 동일 체크 end*/
/*결제 정보 start*/
function pointcheck(m_point){
	var point =  document.getElementById("point").value*1;
	if(m_point<point){
		alert("포인트가 부족합니다.");
		point=0;
	}else{
		document.getElementById("usepoint").innerHTML = point;
		document.getElementById("leftpoint").innerHTML = (m_point-point);
	}
	var totalprice =  document.getElementById("totalprice").innerHTML*1;
	var totaldeliverypay =  document.getElementById("totaldeliverypay").innerHTML*1;
	document.getElementById("totalpay").innerHTML = totalprice+totaldeliverypay-point;
}
/*결제 정보 end*/
/*주문목록 스크롤(Jquery) start*/
	/*$(window) : 현재 창*/
	var item = 2; // 기본 주문2개를 제외한 세번째 주문부터
	$(window).scroll(function(){
		/*$(window).scrolltop()) : 현재 스크롤의 위치*/
		/*alert("현재 스크롤 위치 : " + $(window).scrolltop());
		alert("현재 화면의 높이[보이는화면] : " + $(window).height());
		alert("현재 문서의 높이[보이지않는 화면까지 포함] : " + $(document).height());*/
		// 스크롤이 바닥에 닿았을때
		if($(window).scrollTop()==$(document).height() - $(window).height()) {
			// (문서전체) 현재스크롤위치 = 문서전체높이 - 현재문서높이
			$.ajax({
				url : "/jsp/website/controller/orderlistscrollcontroller.jsp",
				data : {item : item},
				success : function(result){
					$("section").append(result);
				}
			});
			item++;	// 스크롤 이벤트가 바닥에 닿았을때 주문1씩 증가
		}
	});




/*주문목록 스크롤 end*/

/* 회원가입 유효성검사 */
  
	function signupcheck(){
	
		// 1. 폼 가져오기 [ 폼에 id 존재 ]	//	document.getElementById("signupform")
		// 2. 폼내 아이디 입력 input 가져오기
		var id = document.getElementById("signupform").id.value;
		var password = document.getElementById("signupform").password.value;
		var passwordconfirm = document.getElementById("signupform").passwordconfirm.value;
		var name = document.getElementById("signupform").name.value;
		var birth = document.getElementById("signupform").birth.value;
		var phone = document.getElementById("signupform").phone.value;
		var sex1 = document.getElementById("signupform").sex1.checked;	// checked 유무 가져오기 
		var sex2 = document.getElementById("signupform").sex2.checked;

		// 3. 유효성검사 [ 정규표현식 : 텍스트 패턴 검사 ] 
		var idj = /^[a-z0-9]{5,15}$/;		// 아이디 정규표현식	[ 소문자 숫자 5~15]
		var pwj = /^[A-Za-z0-9]{5,15}$/;	// 비밀번호 정규표현식[ 대,소문자 숫자 5~15]
		var phonej = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/; // 연락처
		var namej = /^[A-Za-z0-9가-힣]{1,15}$/;	// 이름 정규표현식
		
		// 아이디 
		if( !idj.test( id ) ){
			document.getElementById("idresult").innerHTML="아이디는 소문자와 숫자 조합 5~15 사이만 가능 합니다";
			document.getElementById("idresult").style.color = "red";
			return false;// form submit 불가
		}else{
			document.getElementById("idresult").innerHTML="사용가능한 아이디 입니다."
			document.getElementById("idresult").style.color = "green";
		}
		
		// 패스워드 [ 두 패스워드 동일한지 검사 ]
		
		if( !pwj.test(password) || !pwj.test(passwordconfirm) ){
			document.getElementById("pwresult").innerHTML="대소문자 조합 5~15 사이만 가능합니다."; return false;
		}else if( password != passwordconfirm){
			document.getElementById("pwresult").innerHTML="패스워드가 동일하지 않습니다.";	
			document.getElementById("pwresult").style.color = "red";
			return false;
		}else{
			document.getElementById("pwresult").innerHTML="패스워드가 일치 합니다.";
			document.getElementById("pwresult").style.color = "green";
		}
		// 이름
		if( !namej.test(name) ){
			document.getElementById("nameresult").innerHTML="이름을 입력해주세요.[특수문자는 제외]"; return false;
		}else{
			document.getElementById("nameresult").innerHTML="";
		}
		//생년월일
		if( birth == ""){
			document.getElementById("birthresult").innerHTML="생년월일 선택해주세요"; return false;
		}else{
			document.getElementById("birthresult").innerHTML="";
		}
		// 성별
		if( !sex1 && !sex2 ){  // 둘다 false 이면 // 둘다 체크를 안했으면
			document.getElementById("sexresult").innerHTML="성별을 선택해주세요"; return false;
		}else{
			document.getElementById("sexresult").innerHTML="";
		}
		// 전화번호 
		if( !phonej.test( phone ) ){
			document.getElementById("phoneresult").innerHTML="전화번호 형식으로 입력해주세요."; return false;
		}else{
			document.getElementById("phoneresult").innerHTML="";
		}
	}

/* 회원가입 유효성검사 end */

