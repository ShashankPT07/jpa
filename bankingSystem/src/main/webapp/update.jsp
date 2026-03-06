<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Bank</title>
</head>
<body>

<form name="updateForm" action="update" method="post" onsubmit="return validateUpdate()">

<input type="number" name="id" value="${dto.id}" readonly>
<br><br>

Name:
<input type="text" name="name" value="${dto.name}" required minlength="3">
<br><br>

Account Number:
<input type="text" name="accountNumber"
pattern="[0-9]{9,18}"
title="Account number must be 9 to 18 digits"
value="${dto.accountNumber}" required>
<br><br>



Bank Name:
<input type="text" name="bankName" value="${dto.bankName}" required minlength="3">
<br><br>

Phone Number:
<input type="text" name="phoneNumber"
pattern="[6-9][0-9]{9}"
title="Phone number must start with 6,7,8,9 and contain 10 digits"
value="${dto.phoneNumber}" required>
<br><br>

Balance:
<input type="number" name="balance" min="1" value="${dto.balance}" required>
<br><br>

<button type="submit">Update</button>

</form>

</body>
</html>