CREATE TABLE IF NOT EXISTS branch_coverage (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  branch_id BIGINT NOT NULL,
  province_code VARCHAR(255) NOT NULL,
  city_code VARCHAR(255) NOT NULL,
  district_code VARCHAR(255) NOT NULL,
  subdistrict_code VARCHAR(255) NOT NULL,
  zipcode VARCHAR(255) NOT NULL,
  active BOOLEAN DEFAULT TRUE,
  created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  created_user VARCHAR(255) DEFAULT 'system',
  updated_date TIMESTAMP NULL,
  updated_user VARCHAR(255),
  CONSTRAINT fk_branch_coverage_branch_id FOREIGN KEY (branch_id) REFERENCES branch (id)
);

DROP INDEX IF EXISTS idx_branch_coverage_province_code;
CREATE INDEX idx_branch_coverage_province_code ON branch_coverage (province_code);

DROP INDEX IF EXISTS idx_branch_coverage_city_code;
CREATE INDEX idx_branch_coverage_city_code ON branch_coverage (city_code);

DROP INDEX IF EXISTS idx_branch_coverage_district_code;
CREATE INDEX idx_branch_coverage_district_code ON branch_coverage (district_code);

DROP INDEX IF EXISTS idx_branch_coverage_subdistrict_code;
CREATE INDEX idx_branch_coverage_subdistrict_code ON branch_coverage (subdistrict_code);

DROP INDEX IF EXISTS idx_branch_coverage_zipcode;
CREATE INDEX idx_branch_coverage_zipcode ON branch_coverage (zipcode);

DROP INDEX IF EXISTS idx_branch_coverage_search_mapping;
CREATE INDEX idx_branch_coverage_search_mapping ON branch_coverage (province_code, city_code, district_code, subdistrict_code, zipcode);
