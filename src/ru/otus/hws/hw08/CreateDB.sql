CREATE TABLE questions
(
	question_id SERIAL PRIMARY KEY,
	question VARCHAR(500) NOT NULL UNIQUE
);
INSERT INTO questions(question)
VALUES
	('Не лает, не кусает, а в дом не пускает'),
	('2 + 2 * 2 = '),
	('Два брюшка, четыре ушка'),
	('Ёжики дома сидели, песню дружно они запели. Первый ёжик: "Фыр-фыр-фыр". Второй ёжик: "Хыр-Хыр-Хыр". Третий ёжик: "Цир-цир-цир". Как запел четвёртый ёжик?')
	;
	
SELECT question_id, question
FROM questions
ORDER BY question_id
;

CREATE TABLE answers
( 	
	answer_id SERIAL PRIMARY KEY,
 	answer VARCHAR(500) NOT NULL UNIQUE,
	is_right BOOLEAN,
	question_id INTEGER REFERENCES questions (question_id) ON DELETE CASCADE ON UPDATE CASCADE	
)
;

INSERT INTO answers(question_id, answer, is_right)
VALUES
        (1, 'конь', false),
        (1, 'дверь', false),
        (1, 'замок', true),
		(1, 'велосипед', false),
		
		(2, '8', false),
		(2, '4', false),
		(2, '10', false),
		(2, '6', true),
		
		(3, 'свинья', false),
		(3, 'толстяк на коне', false),
		(3, 'подушка', true),
		(3, 'ножницы', false),
		(3, 'олень', false),
		
		(4, 'Арр-арр-арр', false),
		(4, 'Урр-урр-урр', false),
		(4, 'Ирр-ирр-ирр', false),
		(4, 'Чирр-чирр-чирр', true)
		
;

SELECT q.question, a.answer, a.is_right
FROM answers AS a
JOIN questions q  ON a.question_id = q.question_id 
ORDER BY q.question_id
;




