/*
  Slidemenu
*/
(function () {
    var $body = document.body
        , $menu_trigger = $body.getElementsByClassName('menu-trigger')[0]
        , $header = $body.getElementsByClassName('header')[0];

    if (typeof $menu_trigger !== 'undefined') {
        $menu_trigger.addEventListener('click', function () {
            $body.className = ( $body.className == 'menu-active' ) ? '' : 'menu-active';
        });
    }

    if (typeof $header !== 'undefined') {
        $header.addEventListener('click', function () {
            $body.className = ( $body.className == 'header-active' ) ? '' : 'header-active';
        });
    }

}).call(this);