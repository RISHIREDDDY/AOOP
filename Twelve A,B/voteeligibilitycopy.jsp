<!DOCTYPE html>
<html>
<head>
    <title>Voter Eligibility</title>
    <script>
        function checkEligibility() {
            // Get name and age from the form
            let name = document.getElementById("name").value;
            let age = document.getElementById("age").value;
            let message = "";

            // Validate if the age is a valid number
            if (isNaN(age) || age === "") {
                message = "Invalid age entered. Please enter a valid number.";
            } else {
                age = parseInt(age); // Convert age to a number
                if (age >= 18) {
                    message = `Hello ${name}, you are eligible to vote!`;
                } else {
                    message = `Hello ${name}, you are not eligible to vote yet.`;
                }
            }

            // Display the message
            document.getElementById("result").innerHTML = message;
            return false; // Prevent form submission
        }
    </script>
</head>
<body>
    <h2>Check Voter Eligibility</h2>
    <form onsubmit="return checkEligibility();">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br><br>
        <input type="submit" value="Check Eligibility">
    </form>
    <p id="result"></p>
</body>
</html>
