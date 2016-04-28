
//validate the input of loginForm
$(document).ready(function(){
	
	//validate log in form
    $('#signInButton').click(function(){
        
        var username = $('#username').val();
        var password = $('#password').val();
        
        // check if the username and password field is not empty
        if(username === null || username === ""){
            //alert("empty");
            $('#displayUsernameError').html("<br/>The field of username must be filled out. (Click me to slide up)");
            $('#displayUsernameError').slideDown(500);
            return false;//stay in 'index.php' instead of directing to other pages
        }else // check if the username and password field is not empty
        if(password === null || password === ""){
            $('#displayPasswordError').html("<br/>The field of password must be filled out. (Click me to slide up)");
            $('#displayPasswordError').slideDown(500);
            return false;//stay in 'index.php' instead of directing to other pages
        }else{// data entered correctly
            //return false;//stay in 'index.php' instead of directing to other pages
        }
    });
    
    //validate register form
    $('#registerButton').click(function(){
        
        var username = $('#username').val();
        var password = $('#password').val();
        
        // check if the username and password field is not empty
        if(username === null || username === ""){
            //alert("empty");
            $('#displayUsernameError').html("<br/>The field of username must be filled out. (Click me to slide up)");
            $('#displayUsernameError').slideDown(500);
            return false;//stay in 'index.php' instead of directing to other pages
        }else // check if the username and password field is not empty
        if(password === null || password === ""){
            $('#displayPasswordError').html("<br/>The field of password must be filled out. (Click me to slide up)");
            $('#displayPasswordError').slideDown(500);
            return false;//stay in 'index.php' instead of directing to other pages
        }else{// data entered correctly
            //return false;//stay in 'index.php' instead of directing to other pages
        }
    });
    
    // click to slide up
    $("p#displayUsernameError").click(function(){
        $(this).slideUp(500);
    });
    $("p#displayPasswordError").click(function(){
        $(this).slideUp(500);
    });
});