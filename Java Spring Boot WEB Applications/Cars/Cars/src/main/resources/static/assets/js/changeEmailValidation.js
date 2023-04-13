const form = document.querySelector('form');
const newEmailInput = form.querySelector('#newEmail');
const confirmEmailInput = form.querySelector('#confirmEmail');
const termsCheckbox = form.querySelector('#acceptTerms');
const submitBtn = form.querySelector('button[type="submit"]');
const currentEmail = form.getAttribute('data-current-email');

submitBtn.addEventListener('click', (event) => {
  event.preventDefault();

  const newEmail = newEmailInput.value.trim();
  const confirmEmail = confirmEmailInput.value.trim();

  // Check if the new email is empty
  if (newEmail === '') {
    newEmailInput.classList.add('is-invalid');
    newEmailInput.nextElementSibling.innerHTML = 'Please enter a new email address.';
    return;
  }

  // Check if the confirm email is empty
  if (confirmEmail === '') {
    confirmEmailInput.classList.add('is-invalid');
    confirmEmailInput.nextElementSibling.innerHTML = 'Please confirm your new email address.';
    return;
  }

  // Check if the new email and confirm email match
  if (newEmail !== confirmEmail) {
    newEmailInput.classList.add('is-invalid');
    confirmEmailInput.classList.add('is-invalid');
    confirmEmailInput.nextElementSibling.innerHTML = 'The email addresses do not match.';
    return;
  }

  // Check if the user agrees to the terms
  if (!termsCheckbox.checked) {
    termsCheckbox.classList.add('is-invalid');
    termsCheckbox.nextElementSibling.innerHTML = 'You must agree to the terms before submitting.';
    return;
  }

  // Check if the new email is the same as the current user email
  if (newEmail === currentEmail) {
    newEmailInput.classList.add('is-invalid');
    newEmailInput.nextElementSibling.innerHTML = 'The new email address cannot be the same as the current email address.';
    return;
  }

  // Submit the form
  form.submit();
});
