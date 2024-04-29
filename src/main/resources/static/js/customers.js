
function showCustomerDetails(id){
    window.location.href = "/customers/" + id + "/details";
}

function deleteCustomer(id){
    if (confirm("Are you sure you want to delete this customer?")){
        var form = document.getElementById("userDetailsFormId")
        form.action = "/customers/" + id + "/delete";
        form.submit();
    }
}

function showMessage(message) {
    var element = document.getElementById('displayMessageId');
    element.classList.remove('d-none');
    element.classList.add('d-block');
    element.innerText = message;
}

// Select the form
//var form = document.getElementById('userDetailsFormId');

// Add an event listener to the form
//form.addEventListener('submit', showToastOnSaveOrUpdateCustomer());
//form.addEventListener('submit', showMessage());

//function showToastOnSaveOrUpdateCustomer() {
//    // Your code to save or update customer data goes here
//
//    // Show the toast message
//    var toastEl = document.getElementById('toastMessageId');
//    var toast = new bootstrap.Toast(toastEl);
//    toast.show();
//}

