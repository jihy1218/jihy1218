
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

