package com.izerui.support {
import com.izerui.support.event.TreeItemClickEvent;

import flash.events.TimerEvent;
import flash.utils.Timer;

import mx.controls.Tree;
import mx.events.ListEvent;

[Event(name="treeItemClick", type="com.izerui.support.event.TreeItemClickEvent")]

public class DoubleClickTree extends Tree {
    private var isDoubleClick:Boolean = false;//判断是否是双击的标志

    public function DoubleClickTree() {
        super();
        this.doubleClickEnabled = true;
        this.addEventListener(ListEvent.ITEM_CLICK, itemClickEvent)
        this.addEventListener(ListEvent.ITEM_DOUBLE_CLICK, itemDoubleClickEvent);
    }

    private function itemDoubleClickEvent(event:ListEvent):void {
        isDoubleClick = true;
    }

    protected function itemClickEvent(event:ListEvent):void {
        isDoubleClick = false;
        var timer:Timer = new Timer(260, 1);
        timer.start();//也就是说两次单击间隔在260毫秒之内的就被认为是双击
        timer.addEventListener(TimerEvent.TIMER, mlsclickOrDouble);//这边的clickOrDouble也可以写成匿名函数，把mouseEvent传进去
    }

    //判断目录树点击方式
    protected function mlsclickOrDouble(event:TimerEvent):void {
        if (this.selectedIndex == -1) {
            return;
        }
        if (isDoubleClick && this.dataDescriptor.hasChildren(this.selectedItem)) { //isBranch 判断是否终止
            this.expandItem(this.selectedItem, !this.isItemOpen(this.selectedItem)); //调用双击响应函数
        } else {
            dispatchEvent(new TreeItemClickEvent("treeItemClick"));//调用单击响应函数
        }
    }

}
}