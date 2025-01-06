!function(){
    let showPasswordCheckbox = document.getElementById("show-password");
    let passwords = document.querySelectorAll('input[type="password"]') 

    let email = document.querySelector('input[type="email"]');
    let emailError = document.getElementById('email-error');

    if(showPasswordCheckbox) {
        showPasswordCheckbox.addEventListener('change', () => {
            passwords.forEach(password => {
                password.type = showPasswordCheckbox.checked ? 'text' : "password";
            })
        })
    }

    if(email) {
        email.addEventListener('input', () => {
            if (!email.value.trim()) {
                emailError.textContent = 'Please enter email';
                email.style.borderColor = 'red';
            } else {
                emailError.textContent = '';
                email.style.borderColor = '';
            }
        })
    }
}();