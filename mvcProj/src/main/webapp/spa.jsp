<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>spa.jsp</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
			<th>아이디</th><th>이름</th><th>이메일</th><th>비밀번호</th>
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
			//데이터 건수 반복
			for(let obj of data){
				//tr만들어서 각각의 값 td안에 넣기
				let tr = document.createElement('tr');
				//필드 갯수 반복
				for(let field of fields){
					let td1 =  document.createElement('td');
					td1.innerText = obj[field];
					tr.append(td1);
				}
				tbody.append(tr);
			}
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
	
	
	</script>
</body>
</html>