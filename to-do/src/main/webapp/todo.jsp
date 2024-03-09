<html>
<style>
    body {font-family: "Arial", sans-serif;}
    tbody {
        font-family: "Arial", sans-serif; /* Change the font family as needed */
        font-size: 14px; /* Change the font size as needed */
    }
</style>
<script>
	$('#targetDate').datepicker({
		format : 'dd/mm/yyyy'
	});
</script>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<body>
<div class="container">
	<form:form method="post" commandName="todo">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="desc">Description</form:label>
			<form:input path="desc" type="text" class="form-control"
				required="required" />
			<form:errors path="desc" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="targetDate">Target Date</form:label>
			<form:input path="targetDate" type="text" class="form-control"
				required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>
		<button type="submit" class="btn btn-success">Submit</button>
	</form:form>
</div>
</body>
<%@ include file="common/footer.jspf"%>
</html>
