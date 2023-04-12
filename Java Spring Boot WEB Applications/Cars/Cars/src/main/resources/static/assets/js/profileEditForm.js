function confirmAction() {
  document.getElementById("popup-container").style.display = "block";
  return false;
}

function hidePopup() {
  document.getElementById("popup-container").style.display = "none";
  document.getElementById("Email").classList.remove("is-invalid");
  document.getElementById("email-error").style.display = "none";
}

function validateEmail(email) {
  const re = /\S+@\S+.\S+/;
  return re.test(email);
}

function submitForm() {
  let emailField = document.getElementById("Email").value;

  if (validateEmail(emailField)) {
    document.getElementById("popup-container").style.display = "none";
    document.getElementById("Email").classList.remove("is-invalid");
    document.getElementById("email-error").style.display = "none";
    document.getElementById("edit-form").submit();
  } else {
    document.getElementById("popup-container").style.display = "none";
    document.getElementById("Email").classList.add("is-invalid");
    document.getElementById("email-error").style.display = "block";
  }
}
