<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spa.jsp</title>
</head>
<body>
	<h3>회원등록</h3>
	<form name="addFrm" action="addMemberAjax.do" method="post">
		아이디: <input type="text" name="id"><br> 
		이름: <input type="text" name="name"><br>
		이메일: <input type="text" name="mail"><br>
		비밀번호: <input type="text" name="passwd"><br>
		<input type="submit" value="저장">
	</form>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>비밀번호</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody id="list"></tbody>
	</table>
	<script>
	//비동식방기(Ajax)
		//2초 있다 결과값
	/* setTimeout(function(){
	console.log("A");
	}, 2000);
		//3초 있다 결과값
	setTimeout(function(){
	console.log("B");		
	}, 3000);
		//4초 있다 결과값
	setTimeout(function(){
	console.log("C");
	}, 1000);
		
	//동기방식
	setTimeout(function(){
	console.log("A");
		setTimeout(function(){
		console.log("B");		
			setTimeout(function(){
			console.log("C");
			}, 1000);
		
		}, 3000);

	}, 2000); */
	
	//비동기 방식 처리
	let i = 0;
	let xhtp = new XMLHttpRequest();
		//object:속성과 기능
	xhtp.open('get', 'memberJson.do');
	xhtp.send();
		//이벤트가 발생하면 함수 실행(콜백 함수)
	xhtp.onreadystatechange = callBackThree;
	
	let fields = ['id', 'name', 'mail', 'passwd']
	function callBackThree(){
		//파싱 먼저
		if(this.readyState == 4 && this.status == 200){
			let data = JSON.parse(this.responseText);
			console.log(data);
			
			let tbody = document.getElementById('list');
			for(let obj of data){
				//tr만들어서 각각의 값 td안에 넣기
				tr = makeTr(obj);
				
				tbody.append(tr);
			}
		}
	}
			//데이터 건수 반복
		// end of callBackThree
		
		function makeTr(obj) {
			let tr = document.createElement('tr');
			//필드 갯수 반복
			for(let field of fields){
				let td1 =  document.createElement('td');
				td1.innerText = obj[field];
				tr.append(td1);
		}
		//삭제 버튼
		let td1 =  document.createElement('td');
		let btn = document.createElement('button');
		btn.innerText = '삭제';
		//클릭이벤트
		btn.addEventListener('click', deleteCallBack);
		td1.append(btn);
			//만들었던 버튼을 자식으로 넣어주기
		tr.append(td1);
		return tr;
	}
			
	function deleteCallBack(e) {
		console.log(this); //event의 call함수()를 가리킴 -> 이벤트를 받는 대상:버튼
		let delId = this.parentElement.parentElement.firstElementChild.innerText;
		let delAjx = new XMLHttpRequest();
		delAjx.open('post', 'removeMemberAjax.do');
		delAjx.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		delAjx.send('id='+delId);
		delAjx.onload = function(){
			//넘어오는 값도 jason으로 받기
			let result = JSON.parse(delAjx.responseText);
			if(result.retCode == 'Success')
				e.target.parentElement.parentElement.remove();
			//화면에서만 지우기 db는 ajax 호출해야함
			else
				alert('처리 중 에러 발생.');
		}
	}
		
	function callBackTwo() {
		if(this.readyState == 4 && this.status == 200){
			let data = JSON.parse(this.responseText);
			console.log(data);
			
			let ul = document.createElement('ul');
			for(let obj of data){
				let li = document.createElement('li');
				li.innerHTML = obj.name + ', ' + obj.age;
				ul.append(li);
			}
			console.log(ul);
			document.querySelector('body').append(ul);
		}
	}
	
	function callBackOne() {
		if(this.readyState == 4 && this.status == 200){
			//let data = console.log(xhtp.responseText);
				//JSON->OBJECT로 parsing해줌
			let data = JSON.parse(this.responseText);
			console.log(data);
			let name = document.createElement('p');
			name.innerText = data.name;
			let age = document.createElement('p');
			age.innerText = data.age;
			document.querySelector('body').append(name, age);
			//document.querySelector('body').append(xhtp.responseText);
		}
	}
	
	//form 전송이벤트가 실행->Ajax 호출
	document.forms.addFrm.onsubmit = function(e){
		//폼 태그 addFrm이라 이름 지정
		//on:event와 관련된 속성들
		//이벤트=콜백함수
		
		//기본 기능 차단
		e.preventDefault();
		//객체 호출해서 send
		
		let url = document.forms.addFrm.getAttribute('action');
		//찾아서 value값 넣어주기
		let id = document.forms.addFrm.id.value;
		let name = document.forms.addFrm.name.value;
		let pass = document.forms.addFrm.passwd.value;
		let mail = document.forms.addFrm.mail.value;
		let param = 'id='+id+'&name='+name+'&passwd='+pass+'&mail='+mail;
		
		let addAjx = new XMLHttpRequest();
		//get,post방식 지정/호출할 url
		addAjx.open('post', url);
		//key, value 형식
		addAjx.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		addAjx.send(param); //id=user1&passw=1234&name=Hong&mail=email@com$"
		addAjx.onload = function(){
			console.log(addAjx.responseText);
			let data = JSON.parse(addAjx.responseText);
			//json -> object로 바꾸기
			//tobdy태그의 id(list)
			document.getElementById('list').append(makeTr(data));
		}
	}
	
	</script>
</body>
</html>