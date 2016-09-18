<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
    <meta name="msapplication-tap-highlight" content="no">
	<link rel="stylesheet" type="text/css" href="../css/free/mui.min.css?v=1">
    <link rel="stylesheet" type="text/css" href="../css/free/mui.picker.css?v=1">
    <link rel="stylesheet" type="text/css" href="../css/free/mui.poppicker.css?v=2">
    <link rel="stylesheet" type="text/css" href="../css/free/reset.css?v=2">
	<link rel="stylesheet" type="text/css" href="../css/free/style.css?v=2">
	  <style>
    *{margin: 0;padding: 0;}
    li{list-style-type: none;}
    a,input{outline: none;-webkit-tap-highlight-color:rgba(0,0,0,0);}
    #choose{display: none;}
    canvas{width: 100%;border: 1px solid #000000;}
    #upload{}
    .touch{background-color: #ddd;}
    .img-list{margin: 10px 5px;}
    .img-list li{position: relative;display: inline-block;width: 100px;height: 100px;margin: 5px 5px 20px 5px;border: 1px solid rgb(100,149,198);background: #fff no-repeat center;background-size: cover;}
    .progress{position: absolute;width: 100%;height: 20px;line-height: 20px;bottom: 0;left: 0;background-color:rgba(100,149,198,.5);}
    .progress span{display: block;width: 0;height: 100%;background-color:rgb(100,149,198);text-align: center;color: #FFF;font-size: 13px;}
    .size{position: absolute;width: 100%;height: 15px;line-height: 15px;bottom: -18px;text-align: center;font-size: 13px;color: #666;}
    .tips{display: block;text-align:center;font-size: 13px;margin: 10px;color: #999;}
    .pic-list{margin: 10px;line-height: 18px;font-size: 13px;}
    .pic-list a{display: block;margin: 10px 0;}
    .pic-list a img{vertical-align: middle;max-width: 30px;max-height: 30px;margin: -4px 0 0 10px;}
  </style>
	
	<script src="../js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=SY5Yi0jB9fz7mrGTWzzf5R7M"></script>
	<script type="text/javascript">
		$('.addrphoto').height($('.addrphoto').width()*0.45);
		
		$(function(){
			
			$("#sub").click(function(){
				var fileName = $(".file").val();
				if (fileName == "") {
					
				 $(".error").html("请上传图片").show();
					return false;
				}
				var provinceAndCity = $("#showCityPicker3").html();
				if (provinceAndCity == "") {
					$(".error").html("请选择省市区").show();
					return false;
				}
				$.ajax({
    				url:"../free/register.jhtml",
    				type:"POST",
    				dataType:"json",
    				data:{"zongbuAddress":$(".zongbuAddress").val(),"beautifulyard":$(".beautifulyard").val(),"openNumber":$(".openNumber").val(),"provinceAndCity":provinceAndCity,"mobile":$(".mobile").val()},
    				success:function(data){
    					if(data == "1"){
    						$("#sub").hide();
    						$(".success").show();
    						$(".error").hide();
    						$("input").each(function(){
    							$(this).attr("disabled",true);
    						});   
    						$("#showCityPicker3").attr("style","pointer-events:none");
    					}else  if (data == "2") {
    						$(".error").html("手机号已注册").show();
    					} else if (data == "12"){
    						$(".error").html("美容院名称不能为空").show();
    					}  else if (data == "13"){
    						$(".error").html("请上传图片").show();
    					} else if (data == "14"){
    						$(".error").html("请输入详细地址").show();
    					}else {
    						$(".error").html("注册失败了").show();
    						//展示错误提示的弹框
    					}
    				},error:function(){
    					$(".error").html("注册失败了").show();
    					//展示错误提示的弹框
    				}
    			});
			});
			
		});
		
		function showBMap(){
			var address = $("#suggestId").val();
			window.location.href="../utils/bmap.jhtml?address="+address;
		}
	</script>
</head>
<body>
	<div class="container height">
		<div class="header-navbar hide">
            <a href="#"><img src="../images/free/icon-lt-red.png"></a>
            开通风尚版
        </div>
        <div class="err-text hide error">您好，您的信息有误，请您确认后重新提醒。</div>
	        <ul class="item-list bg-fff">
	        	<li class="hidden">
	        		<div class="item-left float-lt">美容院名称<font color="red">*</font></div>
	        		<div class="item-right float-rt">
	        		<input type="text" name="beautifulyard" placeholder="请输入您的美容院名称" class="beautifulyard">
	        		<input type="hidden" name="mobile" class="mobile" value="${mobile}">
	        		</div>
	        	</li>
	        	<li class="hidden">
	        		<div class="item-left float-lt">客服电话<font color="red">*</font></div>
	        		<div class="item-right float-rt"><input type="tel" name="openNumber" maxlength="20" class="openNumber" placeholder="请输入客服电话" ></div>
	        	</li>
	        	<li class="hidden">
	        		<!-- <iframe name="ajaxUpload" style="display:none"  id='hiddenIFrame'></iframe>
	        		<form name="from1" id="from1" method="post" action="../free/fileRisterUpload.jhtml" enctype="multipart/form-data" target="ajaxUpload">
		        		<div class="item-left float-lt">门店照片<font color="red">*</font></div>
		        		<div class="item-right relative float-rt" style="cursor: pointer;">
			        		<img class="addrphoto hidden" src="../images/free/addphoto.png" id="rrr"  >
			        		<input type="file" name="myfile" id="file_input" id="myfile" class="file posi-right"/>
		        		</div>
	        		</form> -->
	        		<div class="item-left float-lt">门店照片<font color="red">*</font></div>
	        		<div class="item-right float-rt">
	        			<input type="file" id="choose" accept="image/*" multiple="multiple" />
						<a id="upload"><ul class="img-list"><img class="addrphoto hidden img-inline-block" src="../images/free/addphoto.png" id="rrr"  ></ul></a>
	        		</div>
	        	</li>
	        	<li class="hidden">
	        		<div class="item-left float-lt" style="cursor: pointer;">省市区<font color="red">*</font></div>
	        		<div class="item-right float-rt" id="showCityPicker3" style="cursor: pointer;"></div>
	        	</li>
	        	<li class="hidden">
	        		<div class="item-left float-lt">详细地址<font color="red">*</font></div>
	        		<div class="item-right float-rt"><input class="addrimg-prev-sib zongbuAddress" type="text" name="zongbuAddress" id="suggestId"  placeholder="请输入详细地址" ><img class="img-inline-block" src="../images/free/addr.png" onclick="showBMap()"></div>
	        		<div id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></div>
	        	</li>
	        	
	        </ul>
	        <a class="submit" href="javascript:void(0)" id="sub">提交申请</a>
        <a class="submit submit-disabled hide success" href="javascript:void(0)" id="success">审核中...</a>
        <p class="sh-text hide success">提交申请成功，申请将在24小时之内进行审核。</p>
	</div>
	
	 <script src="../js/free/mui.min.js?v=2"></script>
    <script type="text/javascript" src="../js/free/city.data-3.js?v=3"></script>
    <script src="../js/free/mui.picker.js?v=2"></script>
    <script src="../js/free/mui.poppicker.js?v=2"></script>
	<script type="text/javascript" src="../js/free/jquery.js?v=3"></script>
	<script type="text/javascript" src="../js/free/font.js?v=3"></script>
<script type="text/javascript">
	$('.addrphoto').height($('.addrphoto').width()*0.45);


// 	var ua = navigator.userAgent.toLowerCase();	//选择当前的机型
// 	if (/iphone|ipad|ipod/.test(ua)) {
// 		    alert("iphone");		
// 	} else if (/android/.test(ua)) {
// 		    alert("android");	
// 	}
/*BmapStart  */
	//百度地图API功能
	function G(id) {
		return document.getElementById(id);
	}
	
// 	var map = new BMap.Map("l-map");
// 	map.centerAndZoom("北京",12);                   // 初始化地图,设置城市和地图级别。
	
	var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
		{"input" : "suggestId"
	});
	
	ac.addEventListener("onhighlight", function(e) {  //鼠标放在下拉列表上的事件
	var str = "";
		var _value = e.fromitem.value;
		var value = "";
		if (e.fromitem.index > -1) {
			value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		}    
		str = "FromItem<br />index = " + e.fromitem.index + "<br />value = " + value;
		
		value = "";
		if (e.toitem.index > -1) {
			_value = e.toitem.value;
			value = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		}    
		str += "<br />ToItem<br />index = " + e.toitem.index + "<br />value = " + value;
		G("searchResultPanel").innerHTML = str;
	});
	
	var myValue;
	ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
	var _value = e.item.value;
		myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
		G("searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;
		
		setPlace();
	});
	
	function setPlace(){
// 		map.clearOverlays();    //清除地图上所有覆盖物
		function myFun(){
			var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
// 			map.centerAndZoom(pp, 18);
// 			map.addOverlay(new BMap.Marker(pp));    //添加标注
		}
// 		var local = new BMap.LocalSearch(map, { //智能搜索
// 		  onSearchComplete: myFun
// 		});
// 		local.search(myValue);
	}

	/*BmapEnd  */
	
	  
// 	    var aaa = document.getElementById("rrr"); //获取显示图片的div元素
// 		var input = document.getElementById("file_input"); //获取选择图片的input元素
		      
// 		      //这边是判断本浏览器是否支持这个API。
// 		if(typeof FileReader==='undefined'){ 
// 		    aaa.innerHTML = "抱歉，你的浏览器不支持 FileReader"; 
// 		    input.setAttribute('disabled','disabled'); 
// 		    //alert("errror");
// 		}else{ 
// 		    $(".error").html("000").show();
// 		    input.addEventListener('click',readFile,false); //如果支持就监听改变事件，一旦改变了就运行readFile函数。
// 		    $(".error").html("00").show();
// 		} 
		
		      
// 		function readFile(){ 
// 			$(".error").html("1").show();
// 		    var file = this.files[0]; //获取file对象你想怎么调试
// 		    $(".error").html("2").show();
// 		    //alert
// 		    //console.log(file);//这没有输出
// 		    //判断file的类型是不是图片类型。我不熟到测试你看看打印出来的是什么
// // 		   if(!/.(gif|jpg|jpeg|png|gif|jpg|png)$/.test(file.type)){
// // 			   //alert("请上传图片格式！");
// // 		    	return false;
// // 		    } else {
// // 		    	$("#from1").submit();
// // 		    }
		    
// // 		    if(!/image\/\w+/.test(file.type)){ 
// // 		        //alert("文件必须为图片！"); 
// // 		        return false; 
// // 		    } else {
// 				document.getElementById("from1").submit();
// 				$(".error").html("3").show();
// // 		    	$("#from1").submit();//我估计ios这个不支持
// // 		    }
// 		    	//alert(2);
// 		    var reader = new FileReader(); //声明一个FileReader实例
// 		    $(".error").html("4").show();
// 		    reader.readAsDataURL(file); //调用readAsDataURL方法来读取选中的图像文件
// 		    //最后在onload事件中，获取到成功读取的文件内容，并以插入一个img节点的方式显示选中的图片
// 		   $(".error").html("5").show();
// 		    reader.onload = function(e){ 
// 		    	$(".error").html(this.result).show();
// 		    	$("#rrr").attr("src",this.result);//这里出现的原因 这个this.result换成地址就可以显示
// 		    	$(".error").html("7").show();
// 		    }
// 		    $(".error").html("8").show();
// 		}
		
		var imgUrl = "";
		(function($$, doc) {
// 			$(".error").html("6").show();         
			$$.init();
			////alert(12)
            $$.ready(function() {
            	////alert(13)
                var cityPicker3 = new $$.PopPicker({
                    layer: 3
                });
            	////alert(14)
                cityPicker3.setData(cityData3);
            	////alert(15)
                var showCityPickerButton = doc.getElementById('showCityPicker3');
            	////alert(16)
                showCityPickerButton.addEventListener('click', function(event) {
                	////alert(17)
                    cityPicker3.show(function(items) {
                    	////alert(18)
                        showCityPickerButton.innerText = (items[0] || {}).text + " " + (items[1] || {}).text + " " + (items[2] || {}).text;
                        //返回 false 可以阻止选择框的关闭
                        //return false;
                    });
                	////alert(109);
                }, false);
            	////alert(110);
            });
        })(mui, document);
		
		 var filechooser = document.getElementById("choose");
		  //    用于压缩图片的canvas
		  var canvas = document.createElement("canvas");
		  var ctx = canvas.getContext('2d');
		  //    瓦片canvas
		  var tCanvas = document.createElement("canvas");
		  var tctx = tCanvas.getContext("2d");
		  var maxsize = 100 * 1024;
		  $("#upload").on("click", function() {
		        filechooser.click();
		      })
		      .on("touchstart", function() {
		        $(this).addClass("touch")
		      })
		      .on("touchend", function() {
		        $(this).removeClass("touch")
		      });
		  filechooser.onchange = function() {
		    if (!this.files.length) return;
		    var files = Array.prototype.slice.call(this.files);
		    if (files.length > 1) {
		      alert("最多同时只可上传9张图片");
		      return;
		    }
		    files.forEach(function(file, i) {
		      if (!/\/(?:jpeg|png|gif)/i.test(file.type)) return;
		      var reader = new FileReader();
		      var li = document.createElement("li");
//		          获取图片大小
		      var size = file.size / 1024 > 1024 ? (~~(10 * file.size / 1024 / 1024)) / 10 + "MB" : ~~(file.size / 1024) + "KB";
		      console.info(size);
		      li.innerHTML = '<div class="progress"><span></span></div><div class="size">' + size + '</div>';
		      $(".img-list").html($(li));
		      reader.onload = function() {
		        var result = this.result;
		        var img = new Image();
		        img.src = result;
		        imgUrl = result;
		        $(li).css("background-image", "url(" + result + ")");
		        //如果图片大小小于100kb，则直接上传
		        if (result.length <= maxsize) {
		          img = null;
		          upload(result, file.type, $(li));
		          return;
		        }
//		      图片加载完毕之后进行压缩，然后上传
		        if (img.complete) {
		          callback();
		        } else {
		          img.onload = callback;
		        }
		        function callback() {
		          var data = compress(img);
		          upload(data, file.type, $(li));
		          img = null;
		        }
		      };
		      reader.readAsDataURL(file);
		    })
		  };
		  
		  //    使用canvas对大图片进行压缩
		  function compress(img) {
		    var initSize = img.src.length;
		    var width = img.width;
		    var height = img.height;
		    //如果图片大于四百万像素，计算压缩比并将大小压至400万以下
		    var ratio;
		    if ((ratio = width * height / 4000000) > 1) {
		      ratio = Math.sqrt(ratio);
		      width /= ratio;
		      height /= ratio;
		    } else {
		      ratio = 1;
		    }
		    canvas.width = width;
		    canvas.height = height;
//		        铺底色
		    ctx.fillStyle = "#fff";
		    ctx.fillRect(0, 0, canvas.width, canvas.height);
		    //如果图片像素大于100万则使用瓦片绘制
		    var count;
		    if ((count = width * height / 1000000) > 1) {
		      count = ~~(Math.sqrt(count) + 1); //计算要分成多少块瓦片
//		            计算每块瓦片的宽和高
		      var nw = ~~(width / count);
		      var nh = ~~(height / count);
		      tCanvas.width = nw;
		      tCanvas.height = nh;
		      for (var i = 0; i < count; i++) {
		        for (var j = 0; j < count; j++) {
		          tctx.drawImage(img, i * nw * ratio, j * nh * ratio, nw * ratio, nh * ratio, 0, 0, nw, nh);
		          ctx.drawImage(tCanvas, i * nw, j * nh, nw, nh);
		        }
		      }
		    } else {
		      ctx.drawImage(img, 0, 0, width, height);
		    }
		    //进行最小压缩
		    var ndata = canvas.toDataURL('image/jpeg', 0.1);
		    console.log('压缩前：' + initSize);
		    console.log('压缩后：' + ndata.length);
		    console.log('压缩率：' + ~~(100 * (initSize - ndata.length) / initSize) + "%");
		    tCanvas.width = tCanvas.height = canvas.width = canvas.height = 0;
		    return ndata;
		  }
		  //    图片上传，将base64的图片转成二进制对象，塞进formdata上传
		  function upload(basestr, type, $li) {
		    var text = window.atob(basestr.split(",")[1]);
		    var buffer = new Uint8Array(text.length);
		    var pecent = 0, loop = null;
		    for (var i = 0; i < text.length; i++) {
		      buffer[i] = text.charCodeAt(i);
		    }
		    var blob = getBlob([buffer], type);
		    var xhr = new XMLHttpRequest();
		    var formdata = getFormData();
		    formdata.append('myfile', blob);
		    console.info(imgUrl);
		    formdata.append('fileUrl', imgUrl);
		    xhr.open('post', '../free/fileRisterUpload.jhtml');
		    xhr.onreadystatechange = function() {
		      if (xhr.readyState == 4 && xhr.status == 200) {
		        var jsonData = JSON.parse(xhr.responseText);
		        var imagedata = jsonData[0] || {};
		        var text = imagedata.path ? '上传成功' : '上传失败';
		        console.log(text + '：' + imagedata.path);
		        clearInterval(loop);
		        //当收到该消息时上传完毕
		        $li.find(".progress span").animate({'width': "100%"}, pecent < 95 ? 200 : 0, function() {
		          $(this).html(text);
		        });
		        if (!imagedata.path) return;
		        $(".pic-list").append('<a href="' + imagedata.path + '">' + imagedata.name + '（' + imagedata.size + '）<img src="' + imagedata.path + '" /></a>');
		      }
		    };
		    //数据发送进度，前50%展示该进度
		    xhr.upload.addEventListener('progress', function(e) {
		      if (loop) return;
		      pecent = ~~(100 * e.loaded / e.total) / 2;
		      $li.find(".progress span").css('width', pecent + "%");
		      if (pecent == 50) {
		        mockProgress();
		      }
		    }, false);
		    //数据后50%用模拟进度
		    function mockProgress() {
		      if (loop) return;
		      loop = setInterval(function() {
		        pecent++;
		        $li.find(".progress span").css('width', pecent + "%");
		        if (pecent == 99) {
		          clearInterval(loop);
		        }
		      }, 100)
		    }
		    xhr.send(formdata);
		  }
		  /**
		   * 获取blob对象的兼容性写法
		   * @param buffer
		   * @param format
		   * @returns {*}
		   */
		  function getBlob(buffer, format) {
		    try {
		      return new Blob(buffer, {type: format});
		    } catch (e) {
		      var bb = new (window.BlobBuilder || window.WebKitBlobBuilder || window.MSBlobBuilder);
		      buffer.forEach(function(buf) {
		        bb.append(buf);
		      });
		      return bb.getBlob(format);
		    }
		  }
		  /**
		   * 获取formdata
		   */
		  function getFormData() {
		    var isNeedShim = ~navigator.userAgent.indexOf('Android')
		        && ~navigator.vendor.indexOf('Google')
		        && !~navigator.userAgent.indexOf('Chrome')
		        && navigator.userAgent.match(/AppleWebKit\/(\d+)/).pop() <= 534;
		    return isNeedShim ? new FormDataShim() : new FormData()
		  }
		  /**
		   * formdata 补丁, 给不支持formdata上传blob的android机打补丁
		   * @constructor
		   */
		  function FormDataShim() {
		    console.warn('using formdata shim');
		    var o = this,
		        parts = [],
		        boundary = Array(21).join('-') + (+new Date() * (1e16 * Math.random())).toString(36),
		        oldSend = XMLHttpRequest.prototype.send;
		    this.append = function(name, value, filename) {
		      parts.push('--' + boundary + '\r\nContent-Disposition: form-data; name="' + name + '"');
		      if (value instanceof Blob) {
		        parts.push('; filename="' + (filename || 'blob') + '"\r\nContent-Type: ' + value.type + '\r\n\r\n');
		        parts.push(value);
		      }
		      else {
		        parts.push('\r\n\r\n' + value);
		      }
		      parts.push('\r\n');
		    };
		    // Override XHR send()
		    XMLHttpRequest.prototype.send = function(val) {
		      var fr,
		          data,
		          oXHR = this;
		      if (val === o) {
		        // Append the final boundary string
		        parts.push('--' + boundary + '--\r\n');
		        // Create the blob
		        data = getBlob(parts);
		        // Set up and read the blob into an array to be sent
		        fr = new FileReader();
		        fr.onload = function() {
		          oldSend.call(oXHR, fr.result);
		        };
		        fr.onerror = function(err) {
		          throw err;
		        };
		        fr.readAsArrayBuffer(data);
		        // Set the multipart content type and boudary
		        this.setRequestHeader('Content-Type', 'multipart/form-data; boundary=' + boundary);
		        XMLHttpRequest.prototype.send = oldSend;
		      }
		      else {
		        oldSend.call(this, val);
		      }
		    };
		  }
		
</script>
</body>
</html>