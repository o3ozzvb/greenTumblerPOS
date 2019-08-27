DROP TABLE IF EXISTS SGT_ACCOUNT CASCADE;
DROP TABLE IF EXISTS SGT_MENU CASCADE;
DROP TABLE IF EXISTS SGT_TUMBLER CASCADE;
DROP TABLE IF EXISTS SGT_PRIVATE_MENU CASCADE;
DROP TABLE IF EXISTS SGT_PERSONAL_OPTION CASCADE;
DROP TABLE IF EXISTS SGT_ORDER CASCADE;
DROP TABLE IF EXISTS SGT_ORDERDETAILS CASCADE;

DROP SEQUENCE IF EXISTS SGT_MENU_SEQ;
DROP SEQUENCE IF EXISTS SGT_TUMBLER_SEQ;
DROP SEQUENCE IF EXISTS SGT_OPTION_SEQ;
DROP SEQUENCE IF EXISTS SGT_ORDER_SEQ;
DROP SEQUENCE IF EXISTS SGT_PRIVATE_MENU_SEQ;

CREATE SEQUENCE SGT_MENU_SEQ 			START 1;
CREATE SEQUENCE SGT_TUMBLER_SEQ 		START 1;
CREATE SEQUENCE SGT_OPTION_SEQ			START 1;
CREATE SEQUENCE SGT_ORDER_SEQ			START 1;
CREATE SEQUENCE SGT_PRIVATE_MENU_SEQ	START 1;


CREATE TABLE SGT_ACCOUNT (
    ACCOUNT_ID	VARCHAR PRIMARY KEY,
    PWD             	VARCHAR,
    FCM_TOKEN	VARCHAR,
    NICKNAME    VARCHAR,
    STAR_TYPE	VARCHAR,
    STAR_CNT        NUMERIC
);

CREATE TABLE SGT_MENU (
	MENU_ID 		NUMERIC PRIMARY KEY,
	IMAGE			VARCHAR,
	CATEGORY1		VARCHAR,
	CATEGORY2		VARCHAR,
	MENU_NAME		VARCHAR,
	SIZE			VARCHAR,
	PRICE			NUMERIC
);

CREATE TABLE SGT_PRIVATE_MENU (
	PRIVATE_MENU_ID	NUMERIC PRIMARY KEY,
	CUP				VARCHAR,
	ACCOUNT_ID		VARCHAR REFERENCES SGT_ACCOUNT(ACCOUNT_ID) ON DELETE CASCADE,
	MENU_ID			NUMERIC REFERENCES SGT_MENU(MENU_ID) ON DELETE CASCADE,
	SHOT			NUMERIC,
	SYRUP			NUMERIC,
	WHIPPED_CREAM	BOOLEAN,
	DRIZZLE			BOOLEAN,
	SIZE			VARCHAR,
	OPTION_SUM		NUMERIC,
	PRICE			NUMERIC
);

CREATE TABLE SGT_TUMBLER (
	TUMBLER_ID			NUMERIC PRIMARY KEY,
	IMAGE				VARCHAR NOT NULL,
	NFC_ID				VARCHAR UNIQUE,
	ACCOUNT_ID 			VARCHAR REFERENCES SGT_ACCOUNT(ACCOUNT_ID) ON DELETE CASCADE,
	TUMBLER_NAME		VARCHAR,
	TUMBLER_PIN			VARCHAR UNIQUE,
	SIZE				VARCHAR DEFAULT 1,--Q
	TUMBLER_MONEY		NUMERIC DEFAULT 0,
	GREEN_SEED			NUMERIC DEFAULT 0,
	LOST_YN				BOOLEAN DEFAULT FALSE,
	PAY_YN				BOOLEAN DEFAULT TRUE,
	PRIVATE_MENU_ID		NUMERIC REFERENCES SGT_PRIVATE_MENU(PRIVATE_MENU_ID) ON DELETE CASCADE
);



CREATE TABLE SGT_ORDER (
	ORDER_ID 		NUMERIC PRIMARY KEY,
	ACCOUNT_ID		VARCHAR REFERENCES SGT_ACCOUNT(ACCOUNT_ID) ON DELETE CASCADE,
	ORDER_TIME		TIMESTAMP	NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRICE			NUMERIC,
	STORE_NAME		VARCHAR DEFAULT '남산스테이트점',
	TUMBLER_ID		NUMERIC REFERENCES SGT_TUMBLER(TUMBLER_ID) ON DELETE CASCADE
);

CREATE TABLE SGT_ORDERDETAILS (
	ORDER_ID		NUMERIC NOT NULL REFERENCES SGT_ORDER(ORDER_ID) ON DELETE CASCADE,
	LINE_ID			NUMERIC,
	PRIVATE_MENU_YN	BOOLEAN,
	PRIVATE_MENU_ID NUMERIC REFERENCES SGT_PRIVATE_MENU(PRIVATE_MENU_ID) ON DELETE CASCADE,
	MENU_ID			NUMERIC REFERENCES SGT_MENU(MENU_ID) ON DELETE CASCADE,
	IS_TUMBLER		BOOLEAN,
	SHOT			NUMERIC DEFAULT 0,
	SYRUP			NUMERIC DEFAULT 0,
	WHIPPED_CREAM		BOOLEAN DEFAULT FALSE,
	DRIZZLE			BOOLEAN DEFAULT FALSE,
	SIZE			VARCHAR,
	OPTION_SUM		NUMERIC DEFAULT 0,
	MENU_CNT		NUMERIC DEFAULT 1,
	PRICE			NUMERIC,

	CONSTRAINT PF PRIMARY KEY (ORDER_ID, LINE_ID)
);

-- USER DUMMY
INSERT INTO SGT_ACCOUNT (ACCOUNT_ID, PWD, FCM_TOKEN, NICKNAME, STAR_TYPE, STAR_CNT)
VALUES ( 'test', 'test', 'csv18gJFRoM:APA91bHXSQ_sYIjDvb5-fbaI8fI2p8mZPylGWks6CuzjZQec-ecmvy37BxYhVke8po14qwHu3gkt3J6_SWlD5Ihrw9mkhY03-oytRN9MsV1M3Z6JcJv6oCoAfwlM_YFY8TAXXXvkTl2N' ,'testuser', 'gold', 1);
INSERT INTO SGT_ACCOUNT (ACCOUNT_ID, PWD, FCM_TOKEN, NICKNAME, STAR_TYPE, STAR_CNT)
VALUES ( 'hojun', 'hojun', 'esSQVmVLZDc:APA91bGRjJd10xJKjg95y4e4K9sFAX7_mPF8owrAXWA3mIjawqcJSI0TIO6lAMPZYNu8oN5UyWRDgAYk8UhnpP8krGooeZ97YtXyjD1UawWF-oirHWJEC0qA2y3fYhXedPu9umjF-xGp', '김호준', 'gold', 1);

INSERT INTO SGT_TUMBLER (TUMBLER_ID, IMAGE, NFC_ID, ACCOUNT_ID, TUMBLER_NAME, TUMBLER_PIN)
VALUES ( NEXTVAL('SGT_TUMBLER_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/tumblers/busan_tumbler.jpg','0002360456', 'hojun', '호준이의 텀블러', '0002360456');
INSERT INTO SGT_TUMBLER (TUMBLER_ID, IMAGE, NFC_ID, ACCOUNT_ID, TUMBLER_NAME, TUMBLER_PIN)
VALUES ( NEXTVAL('SGT_TUMBLER_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/tumblers/busan_tumbler.jpg', '1234567890', 'hojun', '호준이의 텀블러', '1234567890');
INSERT INTO SGT_TUMBLER (TUMBLER_ID, IMAGE, NFC_ID, ACCOUNT_ID, TUMBLER_NAME, TUMBLER_PIN)
VALUES ( NEXTVAL('SGT_TUMBLER_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/tumblers/jeju_eco.jpg', '0987654321', 'test', 'test_sgt', '0987654321');
INSERT INTO SGT_TUMBLER (TUMBLER_ID, IMAGE, NFC_ID, ACCOUNT_ID, TUMBLER_NAME, TUMBLER_PIN, LOST_YN, PAY_YN)
VALUES ( NEXTVAL('SGT_TUMBLER_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/tumblers/reserve_white.jpg', '1234512345', 'test', 'test_sgt', '1234512345', TRUE, FALSE);
INSERT INTO SGT_TUMBLER (TUMBLER_ID, IMAGE, NFC_ID, ACCOUNT_ID, TUMBLER_NAME, TUMBLER_PIN, LOST_YN, PAY_YN)
VALUES ( NEXTVAL('SGT_TUMBLER_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/tumblers/reserve_white.jpg', '0001705096', 'test', '분실텀블러', '0001705096', TRUE, FALSE);

-- MENU DUMMY
-- ESPRESSO
INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/ice_americano.jpg', '음료', '에스프레소', '아이스 카페 아메리카노', 1, 4100);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/espresso.jpg', '음료', '에스프레소', '에스프레소', 1, 3600);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/ice_cafe_moca.jpg', '음료', '에스프레소', '아이스 카페모카', 1, 5100 );

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/ice_cafe_latte.jpg', '음료', '에스프레소', '아이스 카페라떼', 1, 4600);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/ice_cappucino.jpg', '음료', '에스프레소', '아이스 카푸치노', 1, 4600);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/dolce_latte.jpg', '음료', '에스프레소', '돌체 콜드 브루', 1, 5600);

-- 프라푸치노
INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/moca_prafuccino.jpg', '음료', '프라푸치노', '모카 프라푸치노', 1, 5600);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/amond_moca_prafuccino.jpg', '음료', '프라푸치노', '아몬드 모카 프라푸치노', 1, 6300);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/espresso_prafuccino.jpg', '음료', '프라푸치노', '에스프레소 프라푸치노', 1, 5100);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/caramel_prafuccino.jpg', '음료', '프라푸치노', '카라멜 프라푸치노', 1, 7200);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/vanilla_cream_praffucino.jpg', '음료', '프라푸치노', '바닐라 크림 프라푸치노', 1, 4800);

-- 블랜디드
INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/decaffeine_apogatto_blended.jpg', '음료', '블렌디드', '디카페인 아포가토 블렌디드', 1, 6100);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/mango_fashion_fruits_blended.jpg', '음료', '블렌디드', '망고 패션 후르츠 블렌디드', 1, 5000);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/jeju_hodu_danggun_blended.jpg', '음료', '블렌디드', '제주 호두 당근 블랜디드', 1, 7200);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/ddalgi_yogurt_blended.jpg', '음료', '블렌디드', '딸기 요거트 블랜디드', 1, 6100);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/mango_banana_blended.jpg', '음료', '블렌디드', '망고 바나나 블랜디드', 1, 6300);

-- 피지오
INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/black_tea_lemonade_figio.jpg', '음료', '피지오', '블랙 티 레모네이드 피지오', 1, 5400);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/cool_lime_figio.jpg', '음료', '피지오', '쿨 라임 피지오', 1, 5900);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/pink_jamong_figio.jpg', '음료', '피지오', '핑크 자몽 피지오', 1, 6300);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/fashion_tango_tea_lemonade_figio.jpg', '음료', '피지오', '패션 탱고 티 레모네이드 피지오', 1, 5400);

-- 티
INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/malcha_lemonade.jpg', '음료', '티', '말차 레모네이드', 1, 6100);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/starbucks_ice_tea.jpg', '음료', '티', '별다방 아이스 티', 1, 5600);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/pinkberry_youthberry.jpg', '음료', '티', '핑크베리 유스베리', 1, 6100);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/grandma_apple_black_tea.jpg', '음료', '티', '그랜마 애플 블랙 티', 1, 7500);

INSERT INTO SGT_MENU (MENU_ID, IMAGE, CATEGORY1, CATEGORY2, MENU_NAME, SIZE, PRICE)
VALUES (NEXTVAL('SGT_MENU_SEQ'), 'https://green-tumbler-server-s3.s3.ap-northeast-2.amazonaws.com/menus/lime_fashion_tea.jpg', '음료', '티', '라임 패션 티', 1, 5600);

--주문정보(헤더)
INSERT INTO SGT_ORDER VALUES ( 2019082301, 'hojun', DEFAULT, 6100, '남산스테이트점', 1 );
INSERT INTO SGT_ORDER VALUES ( 2019082302, 'hojun', DEFAULT, 4100, '남산스테이트점', 1 );

--주문정보(디테일)
INSERT INTO SGT_ORDERDETAILS (ORDER_ID, LINE_ID, PRIVATE_MENU_YN, PRIVATE_MENU_ID, MENU_ID, IS_TUMBLER, SIZE, PRICE, SYRUP, SHOT) VALUES ( 2019082301, 1, FALSE, NULL, 24, TRUE, 'T', 6100, 1, 2);
INSERT INTO SGT_ORDERDETAILS (ORDER_ID, LINE_ID, PRIVATE_MENU_YN, PRIVATE_MENU_ID, MENU_ID, IS_TUMBLER, SIZE, PRICE, SYRUP, SHOT) VALUES ( 2019082302, 1, FALSE, NULL, 1, TRUE, 'T', 4100, 3, 4);

--나만의 메뉴
INSERT INTO SGT_PRIVATE_MENU 
(PRIVATE_MENU_ID, CUP, ACCOUNT_ID, MENU_ID, SHOT, SYRUP, WHIPPED_CREAM, DRIZZLE, SIZE, OPTION_SUM, PRICE)
VALUES
(NEXTVAL('SGT_PRIVATE_MENU_SEQ'), 'T', 'hojun', 2, 1, 1, false, false, 'T', 1200, 5300);

INSERT INTO SGT_PRIVATE_MENU 
(PRIVATE_MENU_ID, CUP, ACCOUNT_ID, MENU_ID, SHOT, SYRUP, WHIPPED_CREAM, DRIZZLE, SIZE, OPTION_SUM, PRICE)
VALUES
(NEXTVAL('SGT_PRIVATE_MENU_SEQ'), 'T', 'hojun', 7, 0, 1, true, false, 'G', 1200, 6000);

