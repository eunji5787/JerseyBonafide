/**
 * 
 */
/**
 * 
 */

function OnlyNumber(event) {
    event = event || window.event;
    var keyID = (event.which) ? event.which : event.keyCode;
    if( ( ( keyID >=48 && keyID <= 57 ) || ( keyID >=96 && keyID <= 105 ) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ))
    {
        return;
    }
    else
    {
        return false;
    }
}

function NotNumber(event) {
    event = event || window.event;
    var keyID = (event.which) ? event.which : event.keyCode;
    if( ( !(( keyID >=48 && keyID <= 57 ) || ( keyID >=96 && keyID <= 105 )) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ))
    {
        return;
    }
    else
    {
        return false;
    }
}


