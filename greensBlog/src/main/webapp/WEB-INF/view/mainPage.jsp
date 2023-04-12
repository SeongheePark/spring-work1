<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main Page</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
<style type="text/css">
@import
	url('https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Gowun+Dodum&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Noto Sans KR', sans-serif;
}
body {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
.body-container {
	width: 1000px;
}

.title-container {
	border: 1px solid gray;
	padding: 5px;
	margin: 5px;
	width: 1000px;
	display: flex;
	background-image: url('/image/title.jpg');
}
.title-box-container {
	display: flex;
	flex: 6;
	align-items: center;
}
.title-icon-container {
	display: flex;
	flex: 1;
	justify-content: center;
	align-items: center;
}
.title-container img {
	align-items: flex-end;
}

.body-container {
	display: flex;
}

.navi-container {
	width: 170px;
	height: 250px;
	border: 2px solid gray;
	border-radius: 10px;
	margin: 20px;
	padding: 10px;
	font-size: 12px;
	color: gray;
}

.navi-title-container {
	display: flex;
}

.navi-title-container>p {
	flex: 3;
}

.navi-title-container>span {
	flex: 1;
}

.navi-container p {
	padding-bottom: 20px;
}

.navi-container ul li {
	list-style: none;
}

.navi-container ul li:hover {
	color: black;
	cursor: pointer;
	font-weight: bold;
}

.main-container {
	width: 730px;
	display: flex;
	flex-direction: column;
	justify-content: center; margin-top : 20px;
	margin-left: 40px;
	margin-top: 20px;
}

.main-title-container {
	font-weight: bold;
	display: flex;
	margin-right: 5px;
	margin-bottom: 10px;
}

.main-title-container>p {
	flex: 15;
}

.main-title-container>span {
	flex: 1;
}

.main-content-container {
	display: flex;
	margin-top: 20px;
}

.main-content {
	flex-direction: column;
	width: 140px;
	margin-right: 20px;
	font-size: 12px;
}

.txt {
	height: 80px;
}

.footer {
	display: flex;
	justify-content: center;
	margin-top: 10px;
}

.footer ul li {
	list-style: none;
	display: inline-block;
	margin: 0, 20px;
}
</style>
</head>
<body>
	<div class="title-container">
		<div class="title-box-container">
			<h1>Green's Blog</h1>
			<span class="material-symbols-outlined">settings</span>
		</div>
		<div class="title-icon-container">
			<a href="https://www.instagram.com/"><img alt="" src="/image/insta.png" ></a>
			<a href="https://www.youtube.com/"><img alt="" src="/image/youtube.png"></a>
		</div>
	</div>
	<div class="body-container">
		<div class="navi-container">
			<div class="navi-title-container">
				<p>전체보기</p>
				<span class="material-symbols-outlined">settings</span>
			</div>
			<ul>
				<li>Python (12)</li>
				<li>Java (2)</li>
				<li>Ios (8)</li>
				<li>소프트웨어 자료 (26)</li>
				<li>자료구조 (8)</li>
				<li>리눅스 (8)</li>
				<li>Git (4)</li>
				<li>자기계발 (3)</li>
				<li>경영전략 (20)</li>
				<li>리더쉽 (2)</li>
			</ul>
		</div>

		<div class="main-container">
			<div class="main-title-container">
				<p>
					경영전략 <span style="color: aqua">20</span>
				</p>
				<span class="material-symbols-outlined">edit_square</span>
			</div>

			<div class="main-body-container">
				<div class="main-content-container">
					<div class="main-content">
						<img alt="" src="/image/content.jpg">
						<p class="txt">팬덤 확보에 성공한 4세대 걸그룹의 차별화 전략</p>
						<p class="date">2022. 12. 8</p>
					</div>
					<div class="main-content">
						<img alt="" src="/image/content.jpg">
						<p class="txt">불황 속에서도 기업 성장 피하는 전략</p>
						<p class="date">2022. 12. 7</p>
					</div>
					<div class="main-content">
						<img alt="" src="/image/content.jpg">
						<p class="txt">CSV 실행, 전략적으로 접근이 필요하다</p>
						<p class="date">2022. 12. 30</p>
					</div>
					<div class="main-content">
						<img alt="" src="/image/content.jpg">
						<p class="txt">뉴노얼 시대 사무실</p>
						<p class="date">2022. 12. 2</p>
					</div>
				</div>
				<div class="main-content-container">
					<div class="main-content">
						<img alt="" src="/image/content.jpg">
						<p class="txt">팬덤 확보에 성공한 4세대 걸그룹의 차별화 전략</p>
						<p class="date">2022. 12. 8</p>
					</div>
					<div class="main-content">
						<img alt="" src="/image/content.jpg">
						<p class="txt">불황 속에서도 기업 성장 피하는 전략</p>
						<p class="date">2022. 12. 7</p>
					</div>
					<div class="main-content">
						<img alt="" src="/image/content.jpg">
						<p class="txt">CSV 실행, 전략적으로 접근이 필요하다</p>
						<p class="date">2022. 12. 30</p>
					</div>
					<div class="main-content">
						<img alt="" src="/image/content.jpg">
						<p class="txt">뉴노얼 시대 사무실</p>
						<p class="date">2022. 12. 2</p>
					</div>
				</div>
				<div class="main-content-container">
					<div class="main-content">
						<img alt="" src="/image/content.jpg">
						<p class="txt">팬덤 확보에 성공한 4세대 걸그룹의 차별화 전략</p>
						<p class="date">2022. 12. 8</p>
					</div>
					<div class="main-content">
						<img alt="" src="/image/content.jpg">
						<p class="txt">불황 속에서도 기업 성장 피하는 전략</p>
						<p class="date">2022. 12. 7</p>
					</div>
					<div class="main-content">
						<img alt="" src="/image/content.jpg">
						<p class="txt">CSV 실행, 전략적으로 접근이 필요하다</p>
						<p class="date">2022. 12. 30</p>
					</div>
					<div class="main-content">
						<img alt="" src="/image/content.jpg">
						<p class="txt">뉴노얼 시대 사무실</p>
						<p class="date">2022. 12. 2</p>
					</div>
				</div>
				<div class="main-content-container">
					<div class="main-content">
						<img alt="" src="/image/content.jpg">
						<p class="txt">팬덤 확보에 성공한 4세대 걸그룹의 차별화 전략</p>
						<p class="date">2022. 12. 8</p>
					</div>
					<div class="main-content">
						<img alt="" src="/image/content.jpg">
						<p class="txt">불황 속에서도 기업 성장 피하는 전략</p>
						<p class="date">2022. 12. 7</p>
					</div>
					<div class="main-content">
						<img alt="" src="/image/content.jpg">
						<p class="txt">CSV 실행, 전략적으로 접근이 필요하다</p>
						<p class="date">2022. 12. 30</p>
					</div>
					<div class="main-content">
						<img alt="" src="/image/content.jpg">
						<p class="txt">뉴노얼 시대 사무실</p>
						<p class="date">2022. 12. 2</p>
					</div>
				</div>
			</div>
			<div class="footer">
				<span class="material-symbols-outlined">arrow_back_ios</span> 이전
				<ul>
					<li>1</li>
					<li>2</li>
					<li>3</li>
					<li>4</li>
					<li>5</li>
					<li>6</li>
					<li>7</li>
					<li>8</li>
					<li>9</li>
					<li>10</li>
				</ul>
				다음 <span class="material-symbols-outlined">arrow_forward_ios</span>
			</div>
		</div>
	</div>

</body>
</html>