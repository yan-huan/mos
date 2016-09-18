(function() {
        //字体
        var width = window.innerWidth;
        var style = document.createElement('style');
        style.innerHTML = 'html{font-size:' + width / 375 * 62.5 + '%;}';
        document.head.appendChild(style);
        // $('html').css('font-size',window.screen.width/375*62.5+'%');
        //高度
        $('.height').height(window.innerHeight); 

    })();