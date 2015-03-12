-- name: all-mps
-- Get all the MPs
SELECT *
FROM mps

-- name: create-mp!
INSERT INTO mps (id, fullname, party, gender, given_name, family_name, additional_name, constituency, twitter, homepage)
VALUES (:id, :fullname, :party, :gender, :given_name, :family_name, :additional_name, :constituency, :twitter, :homepage)

--name: create-mp-j!
INSERT INTO mpsj (mp) VALUES (:mp::json);

--name: all-mpsj
SELECT *
FROM mpsj

--name: create-aye-j!
INSERT INTO ayesj (aye) VALUES (:aye::json);
