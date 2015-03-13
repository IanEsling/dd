-- name: all-mps
-- Get all the MPs
SELECT *
FROM mps

-- name: create-mp!
INSERT INTO mps (id, fullname, party, gender, given_name, family_name, additional_name, constituency, twitter, homepage)
VALUES (:id, :fullname, :party, :gender, :given_name, :family_name, :additional_name, :constituency, :twitter, :homepage)

--name: create-mp-j!
INSERT INTO mpsj (mp_id, mp) VALUES (:mp_id, :mp::json);

--name: all-mpsj
SELECT *
FROM mpsj

--name: create-aye-j!
INSERT INTO ayesj (mp_id, aye) VALUES (:mp_id, :aye::json);

--name: create-no-j!
INSERT INTO noesj (mp_id, no) VALUES (:mp_id, :no::json);
