/*Javascript代码片段*/
$.fn.extend({
  tab: function (index) {
        this.each(function () {
            var animating = false;
            var $this = $(this);
            var $tabCard = $this.children(".tab-card");
            var $tabCards = $tabCard.children();
            var $tabPaper = $this.children(".tab-paper");
            var $tabPapers = $tabPaper.children();
            var curIndex = $tabCards.filter(".cur").index();
            curIndex = index || (curIndex == -1 ? 0 : curIndex) || 0;
            $tabCards.removeClass("cur");
            $tabPapers.removeClass("cur");
            $tabCards.eq(curIndex).addClass("cur");
            $tabPapers.eq(curIndex).addClass("cur");

            $tabCard.each(function () {
                var b = $(this), noop = function () {
                }, $back = $('<li class="back"><div class="left"></div></li>').appendTo(b), $li = $("li", this), curr = $("li.cur", this)[0] || $($li[0]).addClass("cur")[0];
                $li.not(".back").hover(function () {
                    move(this)
                }, noop);
                $(this).hover(noop, function () {
                    move(curr)
                });
                $li.not(".back").click(function (e) {
                    if (!animating) {
                        setCurr(this);
                    }
                });
                setCurr(curr);
                function setCurr(a) {
                    $back.css({"left": a.offsetLeft + "px", "width": a.offsetWidth + "px"});
                    curr = a
                }

                function move(a) {
                    $back.each(function () {
                        $(this).dequeue()
                    }).animate({width: a.offsetWidth, left: a.offsetLeft}, 500, "easeOutBack");
                }
            });

            $tabCards.on("click", function () {
                slide(this)
            });
            function changeCard(the) {
                var $t = $(the);
                $t.addClass("cur").siblings().removeClass("cur");
            }

            function changePaper(the) {
                var $t = $(the);
                var ci = $t.index();
                $tabPapers.eq(ci).addClass("cur").siblings().removeClass("cur");
                curIndex = ci;
                $tabPaper.height($tabPapers.eq(ci).height());
            }

            function slide(the) {
                if (!animating) {
                    var $t = $(the);
                    changeCard(the);
                    var ci = $t.index();
                    if (ci == curIndex) return;
                    var $fromPaper = $tabPapers.eq(curIndex);
                    var $toPaper = $tabPapers.eq(ci);
                    var $fromPaper_clone = $fromPaper.clone();
                    var $toPaper_clone = $toPaper.clone();
                    var paperWidth = $tabPaper.width();
                    var paperPadding = $tabPaper.css("padding");
                    var paperPaddingLeft = parseInt($tabPaper.css("padding-left"));
                    var paperWidthTotal = paperWidth + 2 * paperPaddingLeft;
                    var paperHeight = Math.max($fromPaper.height(), $toPaper.height());
                    $fromPaper_clone.css({
                        float: "left",
                        display: "block",
                       /* background: "#E8F4F3",*/
                        padding: paperPadding,
                        width: paperWidth,
                        height: $fromPaper.height()
                    });
                    $toPaper_clone.css({
                        float: "left",
                        "display": "block",
                       /* background: "#E8F4F3",*/
                        padding: paperPadding,
                        "width": paperWidth,
                        height: $toPaper.height()
                        
                    });
                    var $animateArea = $("<div></div>");
                    $animateArea.css({
                        "position": "absolute",
                        "top": 0,
                        left: 0,
                        width: 2 * paperWidthTotal,
                        height: paperHeight
                        
                    });
                    var animateLeft;
                    if (ci > curIndex) {
                        $animateArea.css("left", 0).append($fromPaper_clone).append($toPaper_clone);
                        animateLeft = -paperWidthTotal;
                    } else if (ci < curIndex){
                        $animateArea.css("left", -paperWidthTotal).append($toPaper_clone).append($fromPaper_clone);
                        animateLeft = 0;
                    }
                    $tabPaper.append($animateArea);
                    $tabPaper.height(paperHeight);
                    $tabPapers.css({"opacity": 0, filter: "alpha(opacity=0)"});
                    animating = true;
                    $animateArea.animate({left: animateLeft}, 500, "easeOutQuint", function () {
                        $animateArea.remove();
                        changePaper(the);
                        $tabPapers.css({"opacity": 1, filter: "alpha(opacity=100)"});
                        animating = false;
                    });
                }
            }
        });
    }

});