<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<title>Bank Form</title>

<script>
function validateForm(){

    let name=document.forms["bankForm"]["name"].value;
    let accountNumber=document.forms["bankForm"]["accountNumber"].value;
    let bankName=document.forms["bankForm"]["bankName"].value;
    let phone=document.forms["bankForm"]["phoneNumber"].value;
    let balance=document.forms["bankForm"]["balance"].value;


    if(name.length < 3){
        alert("Name must be minimum 3 characters");
        return false;
    }


    let accPattern=/^[0-9]{9,18}$/;
    if(!accPattern.test(accountNumber)){
        alert("Account number must be 9 to 18 digits");
        return false;
    }


    if(bankName.length < 3){
        alert("Bank name must be minimum 3 characters");
        return false;
    }


    let phonePattern=/^[0-9]{10}$/;
    if(!phonePattern.test(phone)){
        alert("Phone number must be 10 digits");
        return false;
    }


    if(balance <= 0){
        alert("Balance must be greater than 0");
        return false;
    }

    return true;
}
</script>

</head>

<body>

<h2>Bank Registration Form</h2>

<p style="color:green;">${success}</p>
<p style="color:red;">${errmsg}</p>

<form name="bankForm" action="saveData" method="post" onsubmit="return validateForm()">

Name:
<input type="text" name="name" required minlength="3">
<br><br>

Account Number:
<input type="text" name="accountNumber"
pattern="[0-9]{9,18}"
title="Account number must be 9 to 18 digits"
required>
<br><br>

Bank Name:
<input type="text" name="bankName" required minlength="3">
<br><br>


Phone Number:
<input type="text" name="phoneNumber"
pattern="^[6-9][0-9]{9}$"
title="Phone number must start with 6,7,8,9 and contain 10 digits"
required>
<br><br>

Balance:
<input type="number" name="balance" min="1" required>
<br><br>

<button type="submit">Submit</button>

</form>
<br>

<a href="read">
    <button type="button">Read All Bank Details</button>
</a>

</body>
</html>