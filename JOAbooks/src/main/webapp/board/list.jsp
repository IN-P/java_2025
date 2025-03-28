<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- hearder -->
<%@ include file="../inc/header.jsp" %>
<!-- hearder -->

	<div class="container my-5">
		<h3> NAVER BOOK </h3>	
		<div class="result">
			
		</div>
		<script>
			//window.onload = function () {}; 브라우저 로딩되면 동작
			//$() jquery
			$(function(){
				
				$.ajax({
				    url:"${pageContext.request.contextPath}/books",
				    dataType:"json", 
				    type:"GET",
				    success:function(json){ 
				    	//1. 데이터 분해
				    	//console.log(json);
				    	let items = json.items;
				    	console.log(items[0]); // 객체1개 items[0] = {title:"",image:"",,,,,,,}
				    	for (let i=0;i<items.length;i++) {
				    		let div = $('<div class="row my-3">'); //<div></div> 태그만들기
				    		let p1 = $('<div class="col-sm-4">').html('<img src="'+items[i].image+'" style="width:100%"/>');
				    		let p2 = $('<div class="col-sm-8">').html(
				    				'<a href="'+items[i].link+'">'+items[i].title+'</a><p>'+
				    				items[i].author+'</p><p>'+
				    				items[i].pubdate+'</p><p>'+
				    				items[i].discount+'</p>'
				    		); //html reset해서 넣기
				    		div.append(p1).append(p2);
				    		$(".result").append(div);
				    	}
				    	//2. 보여줄화면에 껴넣기
				    },
				    error:function(xhr, textStatus, errorThrown){
				       $(".result").html(textStatus + "(HTTP-" + xhr.status + "/" + errorThrown);
				    } // $(".result")  document.querySelector(".result")
				});
				
			}); // jQuery야 동작해줘
		</script>
	</div>
	
	<div class="container my-5">
		<h3>MULTIBOARD</h3>
		<%-- <%=request.getAttribute("list")%> --%>
		<p>MULTIBOARD</p>
		<table class="table table-dark table-hover text-center">
			<caption>MULTIBOARD-LIST</caption>
			<thead>
				<tr>
					<th scope="col">NO</th>
					<th scope="col">TITLE</th>
					<th scope="col">WRITER</th>
					<th scope="col">DATE</th>
					<th scope="col">HIT</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="l" varStatus="status">
					<tr>
						<td>${list.size() - status.index}</td>
						<td><a href="detail.do?bno=${l.bno}">${l.btitle}</a></td>
						<td>${l.bname}</td>
						<td>${l.bdate}</td>
						<td>${l.bhit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="text-end">
			<br><a href="write_view.do" alt="" class="btn btn-danger text-white">글쓰기</a>
		</div>
	</div>
	

<!-- footer -->	
<%@ include file="../inc/footer.jsp" %>
<!-- footer -->