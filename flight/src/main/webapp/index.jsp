<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Flight Registration</title>
</head>
<body style="margin:0; height:100vh; display:flex; justify-content:center; align-items:center;">

    <div style="text-align:center; padding:30px; border-radius:10px; box-shadow:0 0 10px rgba(0,0,0,0.1);">

        <h2>Flight Registration Form</h2>

        <!-- Success Message -->
        <h3 style="color: green;">
            ${dto.flightNumber},
            ${success}
        </h3>

        <!-- Error Message -->
        <h3 style="color: red;">
            ${invalid}
        </h3>

        <form action="fly" method="post">

            <label>Flight Number:</label><br>
            <input type="text" name="flightNumber" required><br><br>

            <label>Airline:</label><br>
            <input type="text" name="airline" required><br><br>

            <label>Departure City:</label><br>
            <input type="text" name="departureCity" required><br><br>

            <label>Arrival City:</label><br>
            <input type="text" name="arrivalCity" required><br><br>

            <label>Price:</label><br>
            <input type="number" name="price" step="0.01" required><br><br>

            <button type="submit">Submit</button>

        </form>

    </div>

</body>
</html>
