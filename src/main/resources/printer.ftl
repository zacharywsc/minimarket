***<没钱赚商店>购物清单***
<#list payItems>
    <#items as payItem>
名称：${payItem.name}，数量：${payItem.amount}${payItem.measurement}，单价：${payItem.price?string["0.00"]}(${currency})，小计：${payItem.total?string["0.00"]}(${currency})<#if payItem.discount != 0>，节省${payItem.discount?string["0.00"]}(${currency})</#if>
       </#items>
</#list>
----------------------
买二赠一商品：
<#list discountItems>
    <#items as discountItem>
名称：${discountItem.name}，数量：${discountItem.amount}${discountItem.measurement}
       </#items>
</#list>
----------------------
总计：${total?string["0.00"]}(${currency})
节省：${discount?string["0.00"]}(${currency})
**********************