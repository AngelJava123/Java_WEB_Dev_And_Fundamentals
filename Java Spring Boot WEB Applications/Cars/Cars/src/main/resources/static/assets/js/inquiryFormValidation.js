function submitForm() {
  var name = document.getElementById("username").value;
  var email = document.getElementById("email").value;
  var mobile = document.getElementById("mobile").value;
  var message = document.getElementById("message").value;
  var terms = document.getElementById("acceptTerms").checked;

  var isValid = true;

  // Validate name field
  if (name.trim() === '') {
    document.getElementById("username").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("username").classList.remove('is-invalid');
  }

  // Validate email field
  if (email.trim() === '' || !isValidEmail(email)) {
    document.getElementById("email").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("email").classList.remove('is-invalid');
  }

  // Validate mobile field
  if (mobile.trim() === '' || !isValidMobile(mobile)) {
    document.getElementById("mobile").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("mobile").classList.remove('is-invalid');
  }

  // Validate message field
  if (message.trim() === '') {
    document.getElementById("message").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("message").classList.remove('is-invalid');
  }

  // Validate terms checkbox
  if (!terms) {
    document.getElementById("acceptTerms").classList.add('is-invalid');
    isValid = false;
  } else {
    document.getElementById("acceptTerms").classList.remove('is-invalid');
  }

  if (isValid) {
    // Submit the form programmatically
    document.getElementById("inquiry-form").submit();

    // Clear form fields
    document.getElementById("inquiry-form").reset();
  }
}

// Helper function to validate name
function isValidName(name) {
  var regex = /^[A-Za-z]+$/;
  return regex.test(name);
}

// Helper function to validate email
function isValidEmail(email) {
  var regex = /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/;
  return regex.test(email);
}

// Helper function to validate mobile number
function isValidMobile(mobile) {
  var regex = /^(088|089|087)\d{7}$/;
  return regex.test(mobile);
}