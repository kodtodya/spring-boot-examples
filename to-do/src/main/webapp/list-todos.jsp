<html>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<style>
    body {font-family: "Arial", sans-serif;}
    tbody {
        font-family: "Arial", sans-serif; /* Change the font family as needed */
        font-size: 14px; /* Change the font size as needed */
    }
</style>
<body>
<div class="container">
	<table class="table table-striped">
		<caption>Your Todos are</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Date</th>
				<th>Completed</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.desc}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy"
							value="${todo.targetDate}" /></td>
					<td>${todo.done}</td>
					<td>
                        <a type="button" class="btn btn-primary" href="update-todo?id=${todo.id}">Edit</a>
                        <a type="button" class="btn btn-warning" href="delete-todo?id=${todo.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a type="button" class="btn btn-success" href="add-todo">Add</a>
	</div>
</div>
</body>
<%@ include file="common/footer.jspf"%>
</html>