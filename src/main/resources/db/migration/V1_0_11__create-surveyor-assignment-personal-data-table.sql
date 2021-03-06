CREATE TABLE IF NOT EXISTS surveyor_assignment_personal_data (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  assignment_id BIGINT NOT NULL,
  customer_id UUID NULL,
  customer_name VARCHAR(255) NULL,
  customer_domicile_address TEXT NULL,
  customer_domicile_additional_address TEXT NULL,
  customer_domicile_province_code VARCHAR(255) NULL,
  customer_domicile_province_name VARCHAR(255) NULL,
  customer_domicile_city_code VARCHAR(255) NULL,
  customer_domicile_city_name VARCHAR(255) NULL,
  customer_domicile_district_code VARCHAR(255) NULL,
  customer_domicile_district_name VARCHAR(255) NULL,
  customer_domicile_subdistrict_code VARCHAR(255) NULL,
  customer_domicile_subdistrict_name VARCHAR(255) NULL,
  customer_domicile_zipcode VARCHAR(255) NULL,
  customer_domicile_longitude NUMERIC(17,10) NULL,
  customer_domicile_latitude NUMERIC(17,10) NULL,
  same_with_domicile BOOLEAN DEFAULT FALSE,
  customer_legal_province_code VARCHAR(255) NULL,
  customer_legal_province_name VARCHAR(255) NULL,
  customer_legal_city_code VARCHAR(255) NULL,
  customer_legal_city_name VARCHAR(255) NULL,
  customer_legal_district_code VARCHAR(255) NULL,
  customer_legal_district_name VARCHAR(255) NULL,
  customer_legal_subdistrict_code VARCHAR(255) NULL,
  customer_legal_subdistrict_name VARCHAR(255) NULL,
  customer_legal_zipcode VARCHAR(255) NULL,
  customer_phone_number VARCHAR(255) NULL,
  customer_selfie_photo VARCHAR(255) NULL,
  customer_identity_card_photo VARCHAR(255) NULL,
  customer_family_card_photo VARCHAR(255) NULL,
  customer_is_married BOOLEAN DEFAULT FALSE,
  customer_spouse_name VARCHAR(255) NULL,
  customer_spouse_occupation_code VARCHAR(255) NULL,
  customer_spouse_occupation_name VARCHAR(255) NULL,
  customer_spouse_phone_number VARCHAR(255) NULL,
  customer_spouse_identity_card_photo VARCHAR(255) NULL,
  customer_mother_maiden_name VARCHAR(255) NULL,
  customer_count_dependency INT NULL,
  customer_house_photo VARCHAR(255) NULL,
  customer_house_two_photo VARCHAR(255) NULL,
  active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_user VARCHAR(255) DEFAULT 'system',
  updated_date TIMESTAMP NULL,
  updated_user VARCHAR(255),
  CONSTRAINT fk_surveyor_assignment_personal_data_surveyor_assignment_assignment_id FOREIGN KEY (assignment_id) REFERENCES surveyor_assignment (id)
);
