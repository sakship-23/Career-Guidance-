// Full expands a tree with a given ID

function convertTrees() {
alert(":p:");
    setDefault("treeClass","mktree");
    setDefault("nodeClosedClass","liClosed");
    setDefault("nodeOpenClass","liOpen");
    setDefault("nodeBulletClass","liBullet");
    setDefault("nodeLinkClass","bullet");
    setDefault("preProcessTrees",true);
    if (preProcessTrees) {
        if (!document.createElement) { return; } // Without createElement, we can't do anything
        uls = document.getElementsByTagName("ul");
        for (var uli=0;uli<uls.length;uli++) {
            var ul=uls[uli];
            if (ul.nodeName=="UL" && ul.className==treeClass) {
                processList(ul);
            }
        }
    }
}

function expandtree(treeId) {

    var ul = document.getElementById(treeId);
    alert("1"+ul);
    
    if (ul == null) { return false; }
    expandCollapseList(ul,nodeOpenClass);
}
 
// Fully collapses a tree with a given ID
function collapseTree(treeId) {
alert("1"+treeId);
    var ul = document.getElementById(treeId);
    if (ul == null) { return false; }
    expandCollapseList(ul,nodeClosedClass);
}
 
// Expands enough nodes to expose an LI with a given ID
function expandToItem(treeId,itemId) {
    var ul = document.getElementById(treeId);
    if (ul == null) { return false; }
    var ret = expandCollapseList(ul,nodeOpenClass,itemId);
    if (ret) {
        var o = document.getElementById(itemId);
        if (o.scrollIntoView) {
            o.scrollIntoView(false);
        }
    }
}
 
// Performs 3 functions:
// a) Expand all nodes
// b) Collapse all nodes
// c) Expand all nodes to reach a certain ID
function expandCollapseList(ul,cName,itemId) {
    if (!ul.childNodes || ul.childNodes.length==0) { return false; }
    // Iterate LIs
    for (var itemi=0;itemi<ul.childNodes.length;itemi++) {
        var item = ul.childNodes[itemi];
        if (itemId!=null && item.id==itemId) { return true; }
        if (item.nodeName == "LI") {
            // Iterate things in this LI
            var subLists = false;
            for (var sitemi=0;sitemi<item.childNodes.length;sitemi++) {
                var sitem = item.childNodes[sitemi];
                if (sitem.nodeName=="UL") {
                    subLists = true;
                    var ret = expandCollapseList(sitem,cName,itemId);
                    if (itemId!=null && ret) {
                        item.className=cName;
                        return true;
                    }
                }
            }
            if (subLists && itemId==null) {
                item.className = cName;
            }
        }
    }
}
 
// Search the document for UL elements with the correct CLASS name, then process them

 
// Process a UL tag and all its children, to convert to a tree
function processList(ul) {
    if (!ul.childNodes || ul.childNodes.length==0) { return; }
    // Iterate LIs
    for (var itemi=0;itemi<ul.childNodes.length;itemi++) {
        var item = ul.childNodes[itemi];
        if (item.nodeName == "LI") {
            // Iterate things in this LI
            var subLists = false;
            for (var sitemi=0;sitemi<item.childNodes.length;sitemi++) {
                var sitem = item.childNodes[sitemi];
                if (sitem.nodeName=="UL") {
                    subLists = true;
                    processList(sitem);
                }
            }
            var s= document.createElement("SPAN");
            var t= '\u00A0'; //  
            s.className = nodeLinkClass;
            if (subLists) {
                // This LI has UL's in it, so it's a +/- node
                if (item.className==null || item.className=="") {
                    item.className = nodeClosedClass;
                }
                // If it's just text, make the text work as the link also
                if (item.firstChild.nodeName=="#text") {
                    t = t+item.firstChild.nodeValue;
                    item.removeChild(item.firstChild);
                }
                s.onclick = function () {
                    this.parentNode.className = (this.parentNode.className==nodeOpenClass) ? nodeClosedClass : nodeOpenClass;
                    return false;
                }
            }
            else {
                // No sublists, so it's just a bullet node
                item.className = nodeBulletClass;
                s.onclick = function () { return false; }
            }
            s.appendChild(document.createTextNode(t));
            item.insertBefore(s,item.firstChild);
        }
    }
}