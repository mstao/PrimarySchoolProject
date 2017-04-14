 // 阻止输出log
        // wangEditor.config.printLog = false;

        var editor = new wangEditor('editor-trigger');
        
        editor.config.pasteFilter=true;
        editor.config.pasteText = true;
        //移除菜单项   video 和location
       /* editor.config.menus = $.map(wangEditor.config.menus, function(item, key) {
          if (item === 'video') {
              return null;
         }
          if (item === 'location') {
              return null;
          }
          if(item==='alignright'){
          	  return null;
          }
          if(item==='table'){
          	  return null;
          }
          return item;
      });*/
        
        // 上传图片
        editor.config.uploadImgUrl = CTPPATH+'/EditorUpload.ado';
        editor.config.uploadParams = {
            // token1: 'abcde',
            // token2: '12345'	
        };
        editor.config.uploadHeaders = {
            // 'Accept' : 'text/x-json'
        }
         editor.config.uploadImgFileName = 'myEditorImgName';

        // 隐藏网络图片
        // editor.config.hideLinkImg = true;

      

        // 插入代码时的默认语言
        // editor.config.codeDefaultLang = 'html'

        // 只粘贴纯文本
        // editor.config.pasteText = true;

        // 跨域上传
        // editor.config.uploadImgUrl = 'http://localhost:8012/upload';

        // 第三方上传
        // editor.config.customUpload = true;

        // 普通的自定义菜单
        editor.config.menus = [
            'source',
            '|',     // '|' 是菜单组的分割线
            'bold',
            'underline',
            'italic',
            'eraser',
            '|',
            'head',
            'quote',
            'unorderlist',
            'orderlist',
            'alignleft',
            'aligncenter',
            'alignright',
            '|',
            'table',
            'link',
            'unlink',
            'img',
            '|',
            'undo',
            'redo',
            'fullscreen'
         ];
          
        // 普通菜单配置
        // editor.config.menus = [
        //     'img',
        //     'insertcode',
        //     'eraser',
        //     'fullscreen'
        // ];
        // 只排除某几个菜单（兼容IE低版本，不支持ES5的浏览器），支持ES5的浏览器可直接用 [].map 方法
        // editor.config.menus = $.map(wangEditor.config.menus, function(item, key) {
        //     if (item === 'insertcode') {
        //         return null;
        //     }
        //     if (item === 'fullscreen') {
        //         return null;
        //     }
        //     return item;
        // });

        // onchange 事件
        // editor.onchange = function () {
        //     console.log(this.$txt.html());
        // };


        // 取消过滤js
        // editor.config.jsFilter = false;

        // 取消粘贴过来
        // editor.config.pasteFilter = false;

        // 设置 z-index
        // editor.config.zindex = 20000;

        // 语言
        // editor.config.lang = wangEditor.langs['en'];

        // 自定义菜单UI
        // editor.UI.menus.bold = {
        //     normal: '<button style="font-size:20px; margin-top:5px;">B</button>',
        //     selected: '.selected'
        // };
        // editor.UI.menus.italic = {
        //     normal: '<button style="font-size:20px; margin-top:5px;">I</button>',
        //     selected: '<button style="font-size:20px; margin-top:5px;"><i>I</i></button>'
        // };
        
        
        //创建编辑器
        editor.create();
        
        
        /*
         * editor.$text
         * 
         * editor.$txt是一个 jquery 封装的div元素，这个div元素就是编辑器的可编辑区域。
         *因此，想要设置、获取、处理编辑器区域的内容，操作这个 editor.$txt 即可。
         * 由于它本身就是 jquery 封装的，因此支持 jquery 所有API
         */
        
        
        //初始化内容
        editor.$txt.html('');
        
        
       /* $(function(){
        	//获取编辑器中的内容
        	$('#bt1').click(function(){
        		// 获取编辑器区域完整html代码
		        var html = editor.$txt.html();
		        alert(html);
		        // 获取编辑器纯文本内容
		        var text = editor.$txt.text();
		        alert(text);
		        // 获取格式化后的纯文本
		        var formatText = editor.$txt.formatText();
		        alert(formatText);
        	});
        	
        	//追加内容
	        $('#btn2').click(function(){
	        	editor.$txt.append('<p>追加的内容</p>');
	        });
	        
	        //清空内容
	        $('#btn3').click(function(){
	        	editor.$txt.html('<p><br></P>');
	        });
        });*/
        
        
       

        