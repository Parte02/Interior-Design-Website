const frmSignIn = document.getElementById('frmSignIn');
const frmForget = document.getElementById('frmForget');
const frmRegister = document.getElementById('frmRegister');

const inputs = document.querySelectorAll('.form_input');
const showPasswordTogglers = document.querySelectorAll('[data-action="toggle-show-password"]');


/* Functions */
const inputLabelFocusOut = event => {
  label = document.querySelector(`label[for="${event.target.id}"]`);
  if(event.target.value.length >0 ) {
    label.classList.add('active');
    label.parentNode.classList.remove('invalid');
  } else {
    label.classList.remove('active');    
  }
}

const inputLabelFocus = event => {
  label = document.querySelector(`label[for="${event.target.id}"]`);
  label.classList.add('active');
  label.parentNode.classList.remove('invalid');
}

const toggleShowPassword = event => {
  const input = document.querySelector(event.target.dataset.input);
  const type = input.getAttribute('type');
  input.setAttribute('type', type==='password'?'text':'password');
}

const showForm = event => {
  event.preventDefault();
  
  for (const form of document.querySelectorAll('.form')) {
    form.classList.remove('active');
  }
  
  for (const error of document.querySelectorAll('.form_inputbox.invalid')) {
    error.classList.remove('invalid');
  }
  
  document.querySelector(event.target.dataset.target).classList.add('active');
}

/* Listener assigns */

for (const input of inputs) {
  input.addEventListener('focusout', inputLabelFocusOut);
  input.addEventListener('focus', inputLabelFocus);
}

for (const toggler of showPasswordTogglers) {
  toggler.addEventListener('click', toggleShowPassword);
}



