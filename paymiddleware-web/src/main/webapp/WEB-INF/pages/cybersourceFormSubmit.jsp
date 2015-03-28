<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Paymiddleware</title>
</head>

<c:set var="context" value="${pageContext.request.contextPath}"/>

<body onload="submit()">
<form id="submitForm" action="https://secureacceptance.cybersource.com/pay" method="post">
    <input type="hidden" name="access_key" value="${access_key}">
    <input type="hidden" name="profile_id" value="${profile_id}">
    <input type="hidden" name="transaction_uuid" value="${transaction_uuid}">
    <input type="hidden" name="signed_field_names" value="${signed_field_names}">
    <input type="hidden" name="unsigned_field_names" value="${unsigned_field_names}">
    <input type="hidden" name="signed_date_time" value="${signed_date_time}">
    <input type="hidden" name="locale" value="${locale}">
    <input type="hidden" name="transaction_type" value="${transaction_type}">
    <input type="hidden" name="reference_number" value="${reference_number}">
    <input type="hidden" name="amount" value="${amount}">
    <input type="hidden" name="currency" value="${currency}">
    <input type="hidden" name="signature" value="${signature}">

</form>
<script type="text/javascript">
    function submit()
    {
        var f = document.getElementById("submitForm");
        f.submit();
    }
</script>

</body>

</html>
