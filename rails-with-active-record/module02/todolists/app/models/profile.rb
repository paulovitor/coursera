class Profile < ActiveRecord::Base
  belongs_to :user

  validate :first_and_last_name_be_null
  validate :invalid_gender
  validate :male_gender_and_sue_first_name

  def first_and_last_name_be_null
    if first_name.nil? && last_name.nil?
      errors.add(:first_name, "and last_name cannot be null")
      errors.add(:last_name, "and first_name cannot be null")
    end
  end

  def invalid_gender
    if gender != "male" && gender != "female"
      errors.add(:gender, "cannot be a invalid gender")
    end
  end

  def male_gender_and_sue_first_name
    if gender == "male" && first_name == "Sue"
      errors.add(:first_name, "cannot be male gender and Sue first_name")
    end
  end

  def self.get_all_profiles(min_year, max_year)
    Profile.where(birth_year: min_year..max_year).order(:birth_year)
  end
end
