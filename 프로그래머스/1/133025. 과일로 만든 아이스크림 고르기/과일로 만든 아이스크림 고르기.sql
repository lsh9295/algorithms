-- 상반기 아이스크림 총주문량이 3,000보다 높으면서 아이스크림의 주 성분이 과일인 아이스크림의 맛을 총주문량이 큰 순서대로 조회하는 SQL
SELECT
    A.FLAVOR
FROM
    FIRST_HALF A, ICECREAM_INFO B
WHERE
    A.FLAVOR = B.FLAVOR AND A.TOTAL_ORDER > 3000 AND B.INGREDIENT_TYPE LIKE 'fruit%'