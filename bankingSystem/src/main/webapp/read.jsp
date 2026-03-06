<%@ page isELIgnored="false" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
    <body>
     <table border="2">
                <tr>

                    <td>Name</td>
                    <td>AccountNumber</td>
                    <td>BankName</td>
                    <td>PhoneNumber</td>
                    <td>Balance</td>
                     <th>Update</th>
                      <th>Delete</th>
                </tr>

                     <c:forEach items="${readDetails}" var="data">
                                <tr>

                                    <td>${data.name}</td>
                                    <td>${data.accountNumber}</td>
                                    <td>${data.bankName}</td>
                                    <td>${data.phoneNumber}</td>
                                    <td>${data.balance}</td>
                                      <td><a href="update?id=${data.id}">update</a></td>
                                      <td><a href="delete?id=${data.id}">delete</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </body>
              </html>