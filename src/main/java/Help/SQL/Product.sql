# 第一步，对客户编号(CustomerId)进行分组计数，计算出各个客户的订单量
select product_no,count(*) as number

from insurance_order

group by user_id;